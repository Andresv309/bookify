
package app.controllers.author;

import app.dao.DAOManager;
import app.dao.exceptions.DAOException;
import app.dao.interfaces.AuthorDAO;
import app.views.author.AuthorPanel;
import app.models.Author;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class AuthorController {
    private AuthorPanel entityPanel;
    private AuthorDAO entityDAO;
    
    private AuthorTableModel entityTableModel;
    private AuthorDetailsController entityDetailsController;
    
    private JTable table;
    private JButton btnCreate;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnSave;
    private JButton btnCancel;
    private JLabel infoTag;
    
    public AuthorController(AuthorPanel view) throws DAOException {
        DAOManager DAOManager = new DAOManager();
        
        /*** Specific dao manager ***/
        this.entityDAO = DAOManager.getDAOinstance().getAuthorDAO();
        
        /*** Specific details controller ***/
        this.entityDetailsController = new AuthorDetailsController(view.getDetailsPanel());
        
        /*** Specific table model ***/
        this.entityTableModel = new AuthorTableModel(this.entityDAO);
        
        this.entityPanel = view;
        
        this.table = entityPanel.getTable();
        this.btnCreate = entityPanel.getBtnCreate();
        this.btnEdit = entityPanel.getBtnEdit();
        this.btnDelete = entityPanel.getBtnDelete();
        this.btnSave = entityPanel.getBtnSave();
        this.btnCancel = entityPanel.getBtnCancel();       
        this.infoTag = entityPanel.getInfoTag();

        this.table.setModel(this.entityTableModel);
        
        this.table.getSelectionModel().addListSelectionListener(e -> {
            boolean validSelection = (this.table.getSelectedRow() != -1);
            this.btnEdit.setEnabled(validSelection);
            this.btnDelete.setEnabled(validSelection);
//            if (!validSelection) this.table.clearSelection();
        });
        
//        this.table.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                // Do nothing when the table gains focus
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                // Clear the selection when the table loses focus
//                table.clearSelection();
//            }
//        });

        this.updatePanelView();
        this.initEvents();
    }
    

    public void initEvents() {
        btnCreate.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {  
                entityDetailsController.setEntity(null);
                entityDetailsController.loadData();
                entityDetailsController.setEditable(true);
                btnSave.setEnabled(true);
                btnCancel.setEnabled(true);
            }
        });
        
        btnEdit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {  
                try {
                    Author entity = getRowSelected();
                    entityDetailsController.setEntity(entity);
                    entityDetailsController.setEditable(true);
                    entityDetailsController.loadData();
                    btnSave.setEnabled(true);
                    btnCancel.setEnabled(true);
                } catch (DAOException ex) {
                    Logger.getLogger(AuthorController.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });
        
        btnDelete.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {  
                if (JOptionPane.showConfirmDialog(
                        null,
                        "¿Seguro desea borrar este registro?",
                        "Borrar Registro",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                ) == JOptionPane.OK_OPTION) {
                    try {
                        Author entity = getRowSelected();
                        entityDAO.delete(entity.getId());
                        updatePanelView();
                        table.clearSelection();
                        btnEdit.setEnabled(false);
                        btnDelete.setEnabled(false);
                        btnSave.setEnabled(false);
                        btnCancel.setEnabled(false);
                    } catch (DAOException ex) {
                        Logger.getLogger(AuthorController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        btnSave.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {  
                try {
                    entityDetailsController.saveData();
                    Author entity = entityDetailsController.getEntity();
                    if (entity.getId() == null) {
                        entityDAO.insert(entity);
                    } else {
                        entityDAO.update(entity);
                    }
                    updatePanelView();
                    cleanSelection();
                } catch (DAOException ex) {
                    Logger.getLogger(AuthorController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btnCancel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {  
                cleanSelection();
            }
        });
    }  

    private Author getRowSelected() throws DAOException {
        Long id = (Long) table.getValueAt(table.getSelectedRow(), 0);
        return entityDAO.get(id);
    }
    
    private void cleanSelection() {
        entityDetailsController.setEntity(null);
        entityDetailsController.setEditable(false);
        entityDetailsController.loadData();
        table.clearSelection();
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
    }
    
    private void updatePanelView() throws DAOException {
        infoTag.setText("Actualizando modelo...");
        entityTableModel.updateView();
        entityTableModel.fireTableDataChanged();
        infoTag.setText(entityTableModel.getRowCount() + "Registros totales.");
    }
    
    
}
