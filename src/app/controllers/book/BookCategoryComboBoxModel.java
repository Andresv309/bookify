
package app.controllers.book;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.CategoryDAO;
import app.models.Category;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;


public class BookCategoryComboBoxModel extends DefaultComboBoxModel<Category>{
    private CategoryDAO categoryDAO;
    private List<Category> categorySelectData = new ArrayList<>();

    public BookCategoryComboBoxModel(CategoryDAO categoryDAO) throws DAOException {
        this.categoryDAO = categoryDAO;
        update();
    }
    
    public void update() throws DAOException {
        if (categoryDAO != null) {
            categorySelectData = categoryDAO.getAll();
            removeAllElements();
            for (Category category : categorySelectData) {
                addElement(category);
            }
        }
    }
    
}
