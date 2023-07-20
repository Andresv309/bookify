
package app.controllers.author;

import app.views.author.AuthorDetailsPanel;
import app.views.author.AuthorPanel;
import app.models.Author;


public class AuthorDetailsController {
    private boolean editable;
    private AuthorDetailsPanel authorDetailsPanel;
    private Author author;

    public AuthorDetailsController(AuthorPanel authorPanel) {
        this.authorDetailsPanel = authorPanel.getDetailsPanel();
    }
    
    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        authorDetailsPanel.getDetailsName().setEditable(editable);
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
    
    public void loadData() {
        if (author != null) {
            authorDetailsPanel.setDetailsNameField(author.getName());
        } else {
            authorDetailsPanel.setDetailsNameField("");
        }
    }
    
    public void saveData() {
        if (author == null) {
            String authorName = authorDetailsPanel.getDetailsNameField();
            author = new Author(authorName);
        } else {
            authorDetailsPanel.setDetailsNameField("");
        } 
    }
    
    
    
}
