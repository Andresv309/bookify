
package app.controllers.marketplace;

import app.dao.DAOManager;
import app.models.Book;
import app.dao.exceptions.DAOException;
import app.dao.interfaces.BookDAO;
import app.views.marketplace.BookView;
import app.views.marketplace.MarketPlacePanel;
import components.mainComponents.swing.PanelBackground;
import java.util.ArrayList;
import java.util.List;


public class MarketplaceController {
    private MarketPlacePanel entityPanel;
    private BookDAO entityDAO;
    
    private PanelBackground portrait;
    private List<Book> booksList = new ArrayList<>();
 
    public MarketplaceController(MarketPlacePanel view) throws DAOException {
        DAOManager DAOManager = new DAOManager();
        
        /*** Specific dao manager ***/
        this.entityDAO = DAOManager.getDAOinstance().getBookDAO();
        this.entityPanel = view;
        
        this.portrait = entityPanel.getPortrait();

        this.updatePanelView();
    }
    

    private void updatePanelView() throws DAOException {
        fetchBooks();
        for (Book book : booksList) {
            
            System.out.println(book);
            
            portrait.add(new BookView("/Images/portadas/" + book.getImgPath()));
            
            System.out.println("si estoy funcionando");
        }
            portrait.updateUI();
    } 
    
    public void fetchBooks() throws DAOException {
        booksList = entityDAO.getAll();
    }
  
}
