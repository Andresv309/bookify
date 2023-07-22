
package app.controllers.stock;

import app.dao.DAOManager;
import app.dao.exceptions.DAOException;
import app.dao.interfaces.StockDAO;
import app.views.stock.StockPanel;
import app.models.Stock;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class StockController {
    private StockPanel entityPanel;
    private StockDAO entityDAO;
    
    private StockTableModel entityTableModel;
    private StockDetailsController entityDetailsController;
    
    private JTable table;
    private JButton btnCreate;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnSave;
    private JButton btnCancel;
    private JLabel infoTag;
    
    public StockController(StockPanel view) throws DAOException {
        DAOManager DAOManager = new DAOManager();
        
        /*** Specific dao manager ***/
        this.entityDAO = DAOManager.getDAOinstance().getStockDAO();
        
        /*** Specific details controller ***/
        this.entityDetailsController = new StockDetailsController(view.getDetailsPanel());
        
        /*** Specific table model ***/
        this.entityTableModel = new StockTableModel(this.entityDAO);
        
        this.entityPanel = view;
        
        this.table = entityPanel.getTable();
        this.btnCreate = entityPanel.getBtnCreate();
        this.btnEdit = entityPanel.getBtnEdit();
        this.btnDelete = entityPanel.getBtnDelete();
        this.btnSave = entityPanel.getBtnSave();
        this.btnCancel = entityPanel.getBtnCancel();       
        this.infoTag = entityPanel.getInfoTag();

        this.table.setModel(this.entityTableModel);
        
        this.btnCreate.setEnabled(false);   
        this.table.getSelectionModel().addListSelectionListener(e -> {
            boolean validSelection = (this.table.getSelectedRow() != -1);
            this.btnEdit.setEnabled(validSelection);            
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
        
        btnEdit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {  
                try {
                    Stock entity = getRowSelected();
                    entityDetailsController.setEntity(entity);
                    entityDetailsController.setEditable(true);
                    entityDetailsController.loadData();
                    btnSave.setEnabled(true);
                    btnCancel.setEnabled(true);
                } catch (DAOException ex) {
                    Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });
                
        btnSave.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {  
                try {
                    entityDetailsController.saveData();
                    Stock entity = entityDetailsController.getEntity();
                    if (entity.getId() != null) {
                        entityDAO.update(entity);
                    }
                    updatePanelView();
                    cleanSelection();
                } catch (DAOException ex) {
                    Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
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

    private Stock getRowSelected() throws DAOException {
        Long id = (Long) table.getModel().getValueAt(table.getSelectedRow(), 0);
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
        infoTag.setText(Integer.toString(entityTableModel.getRowCount()));
    } 
}
