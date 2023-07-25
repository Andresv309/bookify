
package app.controllers.book;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.AuthorDAO;
import app.dao.interfaces.CategoryDAO;
import app.models.Author;
import app.views.book.BookDetailsPanel1;
import app.models.Book;
import app.models.Category;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class BookDetailsController {
    private boolean editable;
    private BookDetailsPanel1 entityDetailsPanel;
    private Book entity;
    
    private BookCategoryComboBoxModel categoryComboBoxModel;
    private BookAuthorComboBoxModel authorComboBoxModel;
    
    private JTextField detailsName;
    private JComboBox<Author> detailsAuthor;
    private JComboBox<Category> detailsCategory;
    private JTextArea detailsDescription;
    private JFormattedTextField detailsPrice;
    private JTextField detailsImgPath;
    private JButton detailsBtnLoadImage;
    

    public BookDetailsController(BookDetailsPanel1 entityDetailsPanel, CategoryDAO categoryDAO, AuthorDAO authorDAO) throws DAOException {
        this.entityDetailsPanel = entityDetailsPanel;
        
        this.categoryComboBoxModel = new BookCategoryComboBoxModel(categoryDAO);
        this.authorComboBoxModel = new BookAuthorComboBoxModel(authorDAO);

        this.detailsName = entityDetailsPanel.getDetailsName();
        this.detailsDescription = entityDetailsPanel.getDetailsDescription();
        this.detailsPrice = entityDetailsPanel.getDetailsPrice();
        this.detailsCategory = entityDetailsPanel.getDetailsCategory();
        this.detailsAuthor = entityDetailsPanel.getDetailsAuthor();
        this.detailsImgPath = entityDetailsPanel.getDetailsImgPath();
        this.detailsBtnLoadImage = entityDetailsPanel.getDetailsBtnLoadImage();
        
        this.detailsCategory.setModel(categoryComboBoxModel);
        this.detailsAuthor.setModel(authorComboBoxModel);
        
        this.addLoadImageEventListenner(detailsBtnLoadImage);
                
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
        detailsImgPath.setEnabled(editable);
    }

    public Book getEntity() {
        return entity;
    }

    public void setEntity(Book entity) {
        this.entity = entity;
    }
    
    public void loadData() throws ParseException {       
        if (entity == null) {
            entity = new Book("", "", new BigDecimal(0), 0L, 0L, "");
        }
        detailsName.setText(entity.getName());
        detailsDescription.setText(entity.getDescription());
        detailsPrice.setValue(entity.getPrice());
        detailsImgPath.setText(entity.getImgPath());
        
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
            entity = new Book("", "", new BigDecimal(0), 0L, 0L, "");
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
        entity.setImgPath(detailsImgPath.getText());
        
 
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
    
    private void addLoadImageEventListenner(JButton detailsBtnLoadImage) {
        detailsBtnLoadImage.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {  
                final int BOOK_ITEM_PORTRAIT_WIDTH = 145;
                final int BOOK_ITEM_PORTRAIT_HEIGHT = 232; 
                final String bookPortraitsBasePath = System.getProperty("user.dir") + "\\src\\Images\\portadas\\";

                JFileChooser jFileChooser = new JFileChooser();
                int jfileChooserState = jFileChooser.showOpenDialog(null);

                // Return if not file choosen
                if (!(jfileChooserState == JFileChooser.APPROVE_OPTION)) return;

                File bookImageFile = jFileChooser.getSelectedFile();
                String bookImageFilePath = bookImageFile.getAbsolutePath();

                String extension = bookImageFilePath.substring(bookImageFilePath.lastIndexOf("."));


                File sourceFile = new File(bookImageFilePath);
                File destinationFile = new File(bookPortraitsBasePath + "holafsd" + extension);

                try {
                    Files.copy(sourceFile.toPath(), destinationFile.toPath());
                } catch (IOException ex) {
                    Logger.getLogger(BookDetailsPanel1.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
     
            
//                try {
//                    entityDetailsController.setEntity(null);
//                    entityDetailsController.loadData();
//                    entityDetailsController.setEditable(true);
//                    btnSave.setEnabled(true);
//                    btnCancel.setEnabled(true);
//                } catch (ParseException ex) {
//                    Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
//                }
            
            
     
            
//                try {
//                    entityDetailsController.setEntity(null);
//                    entityDetailsController.loadData();
//                    entityDetailsController.setEditable(true);
//                    btnSave.setEnabled(true);
//                    btnCancel.setEnabled(true);
//                } catch (ParseException ex) {
//                    Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
        });
    }
    
    private void resizeBookPortrait() {
        
    }
    
    
    
    
    
    
    
    
}
