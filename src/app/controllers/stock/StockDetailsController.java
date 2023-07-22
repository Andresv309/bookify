
package app.controllers.stock;

import app.views.stock.StockDetailsPanel;
import app.models.Stock;
import javax.swing.JSpinner;


public class StockDetailsController {
    private boolean editable;
    private StockDetailsPanel entityDetailsPanel;
    private Stock entity;
    
    private JSpinner detailsQuantity;   

    public StockDetailsController(StockDetailsPanel entityDetailsPanel) {
        this.entityDetailsPanel = entityDetailsPanel;
        
        this.detailsQuantity = entityDetailsPanel.getDetailsQuantity();
        this.setEditable(false);
    }
    
    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        detailsQuantity.setEnabled(editable);
        
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
        detailsQuantity.requestFocus();
    }
    
    public void saveData() {
        if (entity == null) {
            entity = new Stock(0L);
        }
        entity.setQuantity((Long) detailsQuantity.getValue());
    }   
     
}
