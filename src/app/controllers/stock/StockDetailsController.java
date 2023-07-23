
package app.controllers.stock;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.ShelveDAO;
import app.models.Shelve;
import app.views.stock.StockDetailsPanel;
import app.models.Stock;
import java.text.ParseException;
import java.util.Objects;
import javax.swing.JComboBox;
import javax.swing.JSpinner;



public class StockDetailsController {
    private boolean editable;
    private StockDetailsPanel entityDetailsPanel;
    private Stock entity;
    
    private StockShelveComboBoxModel shelveComboBoxModel;
    
    private JSpinner detailsQuantity;
    private JComboBox<Shelve> detailsShelve;

    public StockDetailsController(StockDetailsPanel entityDetailsPanel, ShelveDAO shelveDAO) throws DAOException {
        this.entityDetailsPanel = entityDetailsPanel;
        
        this.shelveComboBoxModel = new StockShelveComboBoxModel(shelveDAO);
        
        this.detailsQuantity = entityDetailsPanel.getDetailsQuantity();
        this.detailsShelve = entityDetailsPanel.getDetailsShelve();
        
        this.detailsShelve.setModel(shelveComboBoxModel);
        
        this.setEditable(false);

    }
    
    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        detailsQuantity.setEnabled(editable);
        detailsShelve.setEnabled(editable);
        
    }

    public Stock getEntity() {
        return entity;
    }

    public void setEntity(Stock entity) {
        this.entity = entity;
    }
    
    public void loadData() {       
        if (entity == null) {
            entity = new Stock(0L);
        }
        detailsQuantity.setValue(Long.valueOf(entity.getQuantity()));
        
        Shelve shelveItem;
        for (int i = 0; i < detailsShelve.getItemCount(); i++) {
            shelveItem = detailsShelve.getItemAt(i);
            if (Objects.equals(shelveItem.getId(), entity.getIdShelve())){
                detailsShelve.setSelectedIndex(i);
                break;
            }
        }

        detailsQuantity.requestFocus();
    }
    
    public void saveData() {
        if (entity == null) {
            entity = new Stock(0L);
        }
        try {
            detailsQuantity.commitEdit();
   
            Integer value = (Integer) detailsQuantity.getValue();
            entity.setQuantity(Long.parseLong(value.toString()));
            
            Shelve shelve = (Shelve) shelveComboBoxModel.getSelectedItem();
            entity.setIdShelve(shelve.getId());
  
        } catch (NumberFormatException ex) {
            System.out.println("Not valid number");
        } catch (ParseException ex) {
            System.out.println("Not valid number");
        }             
    }   

    public void setShelveComboBoxModel(StockShelveComboBoxModel shelveComboBoxModel) {
        this.shelveComboBoxModel = shelveComboBoxModel;
        detailsShelve.setModel(shelveComboBoxModel);
    }

}
