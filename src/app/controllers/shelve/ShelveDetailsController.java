
package app.controllers.shelve;

import app.views.shelve.ShelveDetailsPanel;
import app.models.Shelve;
import javax.swing.JTextField;


public class ShelveDetailsController {
    private boolean editable;
    private ShelveDetailsPanel entityDetailsPanel;
    private Shelve entity;
    
    private JTextField detailsName;   

    public ShelveDetailsController(ShelveDetailsPanel entityDetailsPanel) {
        this.entityDetailsPanel = entityDetailsPanel;
        
        this.detailsName = entityDetailsPanel.getDetailsName();
        this.setEditable(false);
    }
    
    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        detailsName.setEnabled(editable);
        
    }

    public Shelve getEntity() {
        return entity;
    }

    public void setEntity(Shelve entity) {
        this.entity = entity;
    }
    
    public void loadData() {       
        if (entity == null) {
            entity = new Shelve("");
        }
        detailsName.setText(entity.getName());
        detailsName.requestFocus();
    }
    
    public void saveData() {
        if (entity == null) {
            entity = new Shelve("");
        }
        entity.setName(detailsName.getText());
    }   
     
}
