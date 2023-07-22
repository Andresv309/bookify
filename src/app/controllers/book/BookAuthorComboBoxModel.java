
package app.controllers.book;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.AuthorDAO;
import app.models.Author;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;


public class BookAuthorComboBoxModel extends DefaultComboBoxModel<Author> {
    private AuthorDAO authorDAO;
    private List<Author> categorySelectData = new ArrayList<>();

    public BookAuthorComboBoxModel(AuthorDAO authorDAO) throws DAOException {
        this.authorDAO = authorDAO;
        update();
    }
    
    public void update() throws DAOException {
        if (authorDAO != null) {
            categorySelectData = authorDAO.getAll();
            removeAllElements();
            for (Author category : categorySelectData) {
                addElement(category);
            }
        }
    }
    
}
