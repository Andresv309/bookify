
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


public class AuthorController implements ActionListener {
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
        
        this.tableModel = new AuthorTableModel(this.authorDAO);
        
        this.authorPanel.getTable().setModel(this.tableModel);
        
        this.detailsModel = new AuthorDetailsController(this.authorPanel);
        
        this.authorPanel.getTable().getSelectionModel().addListSelectionListener(e -> {
            boolean validSelection = (this.authorPanel.getTable().getSelectedRow() != -1);
            authorPanel.getBtnEdit().setEnabled(validSelection);
            authorPanel.getBtnDelete().setEnabled(validSelection);
        
        });
        
        this.table = authorPanel.getTable();
        this.btnCreate = authorPanel.getBtnCreate();
        this.btnEdit = authorPanel.getBtnEdit();
        this.btnDelete = authorPanel.getBtnDelete();
        this.btnSave = authorPanel.getBtnSave();
        this.btnCancel = authorPanel.getBtnCancel();       
        this.infoTag = authorPanel.getInfoTag();
        
        this.updatePanelView();
    }
    
    private void editActionPerformed () {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnCreate) {
            detailsModel.setAuthor(null);
            detailsModel.loadData();
            detailsModel.setEditable(true);  
        }
        if (e.getSource() == btnEdit){
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
        if (e.getSource() == btnDelete) {
            if (JOptionPane.showConfirmDialog(
                    null,
                    "¿Seguro desea borrar este registro?",
                    "Borrar Registro",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            ) == JOptionPane.OK_OPTION) {
                try {
                    Author author = getRowSelected();
                    authorDAO.delete(author.getId());
                    updatePanelView();
                    tableModel.fireTableDataChanged();
                } catch (DAOException ex) {
                    Logger.getLogger(AuthorController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource() == btnSave) {
            try {
                detailsModel.saveData();
                Author author = detailsModel.getAuthor();
                if (author.getId() == null) {
                    authorDAO.insert(author);
                } else {
                    authorDAO.update(author);
                }
                cleanSelection();
                updatePanelView();
                tableModel.fireTableDataChanged();
            } catch (DAOException ex) {
                Logger.getLogger(AuthorController.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        if (e.getSource() == btnCancel) {
            cleanSelection();
        }
        
    }
        
    private Author getRowSelected() throws DAOException {
        JTable table = authorPanel.getTable();
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
        infoTag.setText(tableModel.getRowCount() + "Registros totales.");
    }
    
    
}
