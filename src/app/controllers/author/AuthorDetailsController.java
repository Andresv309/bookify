
package app.controllers.author;

import app.views.author.AuthorDetailsPanel;
import app.models.Author;
import javax.swing.JTextField;


public class AuthorDetailsController {
    private boolean editable;
    private AuthorDetailsPanel entityDetailsPanel;
    private Author entity;
    
    private JTextField detailsName;   

    public AuthorDetailsController(AuthorDetailsPanel entityDetailsPanel) {
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

    public Author getEntity() {
        return entity;
    }

    public void setEntity(Author entity) {
        this.entity = entity;
    }
    
    public void loadData() {       
        if (entity == null) {
            entity = new Author("");
        }
        detailsName.setText(entity.getName());
        detailsName.requestFocus();
    }
    
    public void saveData() {
        if (entity == null) {
            entity = new Author("");
        }
        entity.setName(detailsName.getText());
    }   
     
}
