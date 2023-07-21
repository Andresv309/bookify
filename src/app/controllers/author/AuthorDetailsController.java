
package app.controllers.author;

import app.views.author.AuthorDetailsPanel;
import app.views.author.AuthorPanel;
import app.models.Author;
import javax.swing.JTextField;


public class AuthorDetailsController {
    private boolean editable;
    private AuthorDetailsPanel authorDetailsPanel;
    private Author author;
    
    private JTextField detailsName;    

    public AuthorDetailsController(AuthorPanel authorPanel) {
        this.authorDetailsPanel = authorPanel.getDetailsPanel();
        
        this.detailsName = authorDetailsPanel.getDetailsName();
    }
    
    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        detailsName.setEditable(editable);
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
    
    public void loadData() {
//        if (author != null) {
//            detailsName.setText(author.getName());
//        } else {
//            detailsName.setText("");
//        }
//        detailsName.requestFocus();
        
        if (author == null) {
            author = new Author("");
        }
        detailsName.setText(author.getName());
        detailsName.requestFocus();
    }
    
    public void saveData() {
//        if (author == null) {
//            String authorName = detailsName.getText();
//            author = new Author(authorName);
//        } else {
//            detailsName.setText("");
//        } 

        if (author == null) {
            author = new Author("");
        }
        author.setName(detailsName.getText());
//        detailsName.setFocusable(false);

    }   
     
}
