
package app.controllers.author;

import app.dao.DAOManager;
import app.dao.exceptions.DAOException;
import app.dao.interfaces.AuthorDAO;
import app.views.author.AuthorPanel;
import app.models.Author;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class AuthorController {
    private AuthorPanel authorPanel;
    private AuthorDAO authorDAO;
    
    private AuthorTableModel tableModel;
    private AuthorDetailsController detailsModel;
    
    private JTable table;
    private JButton btnCreate;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnSave;
    private JButton btnCancel;
    private JLabel infoTag;
    
    public AuthorController(AuthorPanel view) throws DAOException {
        DAOManager DAOManager = new DAOManager();
        this.authorDAO = DAOManager.getDAOinstance().getAuthorDAO();
        this.authorPanel = view;
        
        this.table = authorPanel.getTable();
        this.btnCreate = authorPanel.getBtnCreate();
        this.btnEdit = authorPanel.getBtnEdit();
        this.btnDelete = authorPanel.getBtnDelete();
        this.btnSave = authorPanel.getBtnSave();
        this.btnCancel = authorPanel.getBtnCancel();       
        this.infoTag = authorPanel.getInfoTag();
        
        this.tableModel = new AuthorTableModel(this.authorDAO);
        
        this.table.setModel(this.tableModel);
        
        this.detailsModel = new AuthorDetailsController(this.authorPanel);
        
        this.table.getSelectionModel().addListSelectionListener(e -> {
            boolean validSelection = (this.table.getSelectedRow() != -1);
            this.btnEdit.setEnabled(validSelection);
            this.btnDelete.setEnabled(validSelection);
        
        });

        this.updatePanelView();
        this.initEvents();
    }
    

    public void initEvents() {
        btnCreate.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {  
                detailsModel.setAuthor(null);
                detailsModel.loadData();
                detailsModel.setEditable(true);
                btnSave.setEnabled(true);
                btnCancel.setEnabled(true);
            }
        });
        
        btnEdit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {  
                try {
                    Author author = getRowSelected();
                    detailsModel.setAuthor(author);
                    detailsModel.setEditable(true);
                    detailsModel.loadData();
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
                        Author author = getRowSelected();
                        authorDAO.delete(author.getId());
                        updatePanelView();
//                        tableModel.fireTableDataChanged();
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
                    detailsModel.saveData();
                    Author author = detailsModel.getAuthor();
                    if (author.getId() == null) {
                        authorDAO.insert(author);
                    } else {
                        authorDAO.update(author);
                    }
                    updatePanelView();
                    cleanSelection();
                    tableModel.fireTableDataChanged();
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
        return authorDAO.get(id);
    }
    
    private void cleanSelection() {
        detailsModel.setAuthor(null);
        detailsModel.setEditable(false);
        detailsModel.loadData();
        table.clearSelection();
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
    }
    
    private void updatePanelView() throws DAOException {
        infoTag.setText("Actualizando modelo...");
        tableModel.updateView();
        tableModel.fireTableDataChanged();
        infoTag.setText(tableModel.getRowCount() + "Registros totales.");
    }
    
    
}
