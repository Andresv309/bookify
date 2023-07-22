
package app.controllers.book;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.AuthorDAO;
import app.dao.interfaces.CategoryDAO;
import app.models.Author;
import app.views.book.BookDetailsPanel;
import app.models.Book;
import app.models.Category;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Objects;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class BookDetailsController {
    private boolean editable;
    private BookDetailsPanel entityDetailsPanel;
    private Book entity;
    
    private BookCategoryComboBoxModel categoryComboBoxModel;
    private BookAuthorComboBoxModel authorComboBoxModel;
    
    private JTextField detailsName;
    private JComboBox<Author> detailsAuthor;
    private JComboBox<Category> detailsCategory;
    private JTextArea detailsDescription;
    private JFormattedTextField detailsPrice;
    

    public BookDetailsController(BookDetailsPanel entityDetailsPanel, CategoryDAO categoryDAO, AuthorDAO authorDAO) throws DAOException {
        this.entityDetailsPanel = entityDetailsPanel;
        
        this.categoryComboBoxModel = new BookCategoryComboBoxModel(categoryDAO);
        this.authorComboBoxModel = new BookAuthorComboBoxModel(authorDAO);

        this.detailsName = entityDetailsPanel.getDetailsName();
        this.detailsDescription = entityDetailsPanel.getDetailsDescription();
        this.detailsPrice = entityDetailsPanel.getDetailsPrice();
        this.detailsCategory = entityDetailsPanel.getDetailsCategory();
        this.detailsAuthor = entityDetailsPanel.getDetailsAuthor();
        
        this.detailsCategory.setModel(categoryComboBoxModel);
        this.detailsAuthor.setModel(authorComboBoxModel);
                
        this.setEditable(false);
    }
    
    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        detailsName.setEnabled(editable);
        detailsDescription.setEnabled(editable);
        detailsPrice.setEnabled(editable);
        detailsCategory.setEnabled(editable);
        detailsAuthor.setEnabled(editable);
    }

    public Book getEntity() {
        return entity;
    }

    public void setEntity(Book entity) {
        this.entity = entity;
    }
    
    public void loadData() throws ParseException {       
        if (entity == null) {
            entity = new Book("", "", new BigDecimal(0), 0L, 0L);
        }
        detailsName.setText(entity.getName());
        detailsDescription.setText(entity.getDescription());
        detailsPrice.setValue(entity.getPrice());
        
        Category categoryItem;
        for (int i = 0; i < detailsCategory.getItemCount(); i++) {
            categoryItem = detailsCategory.getItemAt(i);
            if (Objects.equals(categoryItem.getId(), entity.getIdCategory())){
                detailsCategory.setSelectedIndex(i);
                break;
            }
        }
        
        Author authorItem;
        for (int i = 0; i < detailsAuthor.getItemCount(); i++) {
            authorItem = detailsAuthor.getItemAt(i);
            if (Objects.equals(authorItem.getId(), entity.getIdCategory())){
                detailsAuthor.setSelectedIndex(i);
                break;
            }
        }
                
        detailsName.requestFocus();
    }
    
    public void saveData() {
        if (entity == null) {
            entity = new Book("", "", new BigDecimal(0), 0L, 0L);
        }
        entity.setName(detailsName.getText());
        Category category = (Category) categoryComboBoxModel.getSelectedItem();
        Author author = (Author) authorComboBoxModel.getSelectedItem();
        entity.setIdCategory(category.getId());
        entity.setIdAuthor(author.getId());
        entity.setPrice(
                new BigDecimal(detailsPrice.getText()
                    .replace(".", "")
                    .replace(",", ".")
                )
        );
        entity.setDescription(detailsDescription.getText());
        
 
    }

    public BookCategoryComboBoxModel getCategoryComboBoxModel() {
        return categoryComboBoxModel;
    }

    public void setCategoryComboBoxModel(BookCategoryComboBoxModel categoryComboBoxModel) {
        this.categoryComboBoxModel = categoryComboBoxModel;
        detailsCategory.setModel(categoryComboBoxModel);
    }

    public BookAuthorComboBoxModel getAuthorComboBoxModel() {
        return authorComboBoxModel;
    }

    public void setAuthorComboBoxModel(BookAuthorComboBoxModel authorComboBoxModel) {
        this.authorComboBoxModel = authorComboBoxModel;
        detailsAuthor.setModel(authorComboBoxModel);
    }
    
    
    
    
}
