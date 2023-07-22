
package app.controllers.category;

import app.views.category.CategoryDetailsPanel;
import app.models.Category;
import javax.swing.JTextField;


public class CategoryDetailsController {
    private boolean editable;
    private CategoryDetailsPanel entityDetailsPanel;
    private Category entity;
    
    private JTextField detailsName;   

    public CategoryDetailsController(CategoryDetailsPanel entityDetailsPanel) {
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

    public Category getEntity() {
        return entity;
    }

    public void setEntity(Category entity) {
        this.entity = entity;
    }
    
    public void loadData() {       
        if (entity == null) {
            entity = new Category("");
        }
        detailsName.setText(entity.getName());
        detailsName.requestFocus();
    }
    
    public void saveData() {
        if (entity == null) {
            entity = new Category("");
        }
        entity.setName(detailsName.getText());
    }   
     
}
