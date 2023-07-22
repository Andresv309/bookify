
package app.controllers.book;

import app.dao.DAOManager;
import app.dao.exceptions.DAOException;
import app.dao.interfaces.BookDAO;
import app.views.book.BookPanel;
import app.models.Book;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class BookController {
    private BookPanel entityPanel;
    private BookDAO entityDAO;
    
    private BookTableModel entityTableModel;
    private BookDetailsController entityDetailsController;
    
    private JTable table;
    private JButton btnCreate;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnSave;
    private JButton btnCancel;
    private JLabel infoTag;
    
    public BookController(BookPanel view) throws DAOException {
        DAOManager DAOManager = new DAOManager();
        
        /*** Specific dao manager ***/
        this.entityDAO = DAOManager.getDAOinstance().getBookDAO();
        
        /*** Specific details controller ***/
        this.entityDetailsController = new BookDetailsController(
                view.getDetailsPanel(),
                DAOManager.getDAOinstance().getCategoryDAO(),
                DAOManager.getDAOinstance().getAuthorDAO()      
        );
        
        /*** Specific table model ***/
        this.entityTableModel = new BookTableModel(this.entityDAO);
        
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
            this.btnCancel.setEnabled(validSelection);
        });
        
        
        // Set first column width shorter because corresponds to index.
        table.getColumnModel().getColumn(1).setMaxWidth(60);
        

        // Remove dbId from the view.
        table.removeColumn(table.getColumnModel().getColumn(0));
        
        
        this.updatePanelView();
        this.initEvents();
    }
    

    public void initEvents() {
        btnCreate.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {  
                try {
                    entityDetailsController.setEntity(null);
                    entityDetailsController.loadData();
                    entityDetailsController.setEditable(true);
                    btnSave.setEnabled(true);
                    btnCancel.setEnabled(true);
                } catch (ParseException ex) {
                    Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btnEdit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {  
                try {
                    Book entity = getRowSelected();
                    entityDetailsController.setEntity(entity);
                    entityDetailsController.setEditable(true);
                    entityDetailsController.loadData();
                    btnSave.setEnabled(true);
                    btnCancel.setEnabled(true);
                } catch (DAOException ex) {
                    Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
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
                        Book entity = getRowSelected();
                        entityDAO.delete(entity.getId());
                        updatePanelView();
                        table.clearSelection();
                        btnEdit.setEnabled(false);
                        btnDelete.setEnabled(false);
                        btnSave.setEnabled(false);
                        btnCancel.setEnabled(false);
                    } catch (DAOException ex) {
                        Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        btnSave.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {  
                try {
                    entityDetailsController.saveData();
                    Book entity = entityDetailsController.getEntity();                  
                    if (entity.getId() == null) {
                        entityDAO.insert(entity);
                    } else {
                        entityDAO.update(entity);
                    }
                    updatePanelView();
                    cleanSelection();
                } catch (DAOException ex) {
                    Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btnCancel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {  
                try {
                    cleanSelection();
                } catch (ParseException ex) {
                    Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }  

    private Book getRowSelected() throws DAOException {
        Long id = (Long) table.getModel().getValueAt(table.getSelectedRow(), 0);
        System.out.println(id);
        return entityDAO.get(id);
    }
    
    private void cleanSelection() throws ParseException {
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
        infoTag.setText(Integer.toString(entityTableModel.getRowCount()));
    } 
}
