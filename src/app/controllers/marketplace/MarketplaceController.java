
package app.controllers.marketplace;

import app.dao.DAOManager;
import app.models.Book;
import app.dao.exceptions.DAOException;
import app.dao.interfaces.BookDAO;
import app.views.marketplace.BookView;
import app.views.marketplace.MarketPlacePanel;
import app.views.shoppingCart.ShoppingCartBookPanel;
import app.views.shoppingCart.ShoppingCartFrame;
import components.mainComponents.swing.PanelBackground;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class MarketplaceController {
    private MarketPlacePanel entityPanel;
    private BookDAO entityDAO;
    
    private PanelBackground portrait;
    private JButton btnOpenShopCart;
    private List<Book> booksList = new ArrayList<>();
    private ShoppingCartFrame shoppingCartFrameInstance = null;
    private boolean isShowing = false;
 
    private List<Book> booksInShopCart = new ArrayList<>();
    private List<ShoppingCartBookPanel> listOfBooksAddedToShopCard = new ArrayList<>();
    private PanelBackground portraitItemsInShopCart = null;
    

    public MarketplaceController(MarketPlacePanel view) throws DAOException {
        DAOManager DAOManager = new DAOManager();
        
        /*** Specific dao manager ***/
        this.entityDAO = DAOManager.getDAOinstance().getBookDAO();
        this.entityPanel = view;
        this.btnOpenShopCart = entityPanel.getBtnOpenShopCart();
        
        this.portrait = entityPanel.getPortrait();

        this.shoppingCartFrameInstance = new ShoppingCartFrame(getSelfInstance());
        this.portraitItemsInShopCart = shoppingCartFrameInstance.getDetailsPortraitItemsInShopCart();
        
        this.updatePanelView();
        this.initEvents();
    }

    public MarketplaceController getSelfInstance() {
        return this;
    }
    
    
    public void initEvents() {
        btnOpenShopCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                isShowing = !isShowing;
                shoppingCartFrameInstance.setVisible(isShowing);
            }
        });
    }

    private void updatePanelView() throws DAOException {
        fetchBooks();
        for (Book book : booksList) {
            BookView bookView = new BookView(book);
            
            portrait.add(bookView);
            addClickEventListener(bookView); 
        }
            portrait.updateUI();
    } 
    
    public void fetchBooks() throws DAOException {
        booksList = entityDAO.getAll();
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public List<ShoppingCartBookPanel> getListOfBooksAddedToShopCard() {
        return listOfBooksAddedToShopCard;
    }

    
    
    public void addClickEventListener(BookView bookView) {
        Book bookItem = bookView.getBookItem();
        JButton addButton = bookView.getDetailsBtnAddBookItem();
                    
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("soy un boton");
//                System.out.println(bookItem);
                
                if (!booksInShopCart.contains(bookItem)) {
                    booksInShopCart.add(bookItem);
     
                    ShoppingCartBookPanel bookPanel = new ShoppingCartBookPanel(bookItem);
                    addChangeEventListener(bookPanel.getDetailsItemAmount());
//                    addRemoveEventListener("iojdsiojdosij");
                    
                    listOfBooksAddedToShopCard.add(bookPanel);

                    portraitItemsInShopCart.add(bookPanel);
                    portraitItemsInShopCart.updateUI();
                    btnOpenShopCart.setText(String.format("%d", listOfBooksAddedToShopCard.size()));
                    
                    
                    try {
                        // Recalculate bill
                        shoppingCartFrameInstance.getShoppingCartController().createCustomerBill();
                    } catch (DAOException ex) {
                        Logger.getLogger(MarketplaceController.class.getName()).log(Level.SEVERE, null, ex);
                    }    
                }
                
//                for (Book booktre : listOfBooksAddedToShopCard) {
//                    System.out.println(booktre);
//                }
            }
        });
    }

    public void setBooksInShopCart(List<Book> booksInShopCart) {
        this.booksInShopCart = booksInShopCart;
    }

    
    public void setListOfBooksAddedToShopCard(List<ShoppingCartBookPanel> listOfBooksAddedToShopCard) {
        this.listOfBooksAddedToShopCard = listOfBooksAddedToShopCard;
    }

    public void setPortraitItemsInShopCart(PanelBackground portraitItemsInShopCart) {
        this.portraitItemsInShopCart = portraitItemsInShopCart;
    }

    public PanelBackground getPortraitItemsInShopCart() {
        return portraitItemsInShopCart;
    }
    
    private void addChangeEventListener(JSpinner jspinner) {
        jspinner.addChangeListener(new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e) {
            try {
                shoppingCartFrameInstance.getShoppingCartController().createCustomerBill();
            } catch (DAOException ex) {
                Logger.getLogger(MarketplaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    }
    
    private void addRemoveEventListener(JButton jbutton, Book bookItem, ShoppingCartBookPanel bookPanel) {
        jbutton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                booksInShopCart.remove(bookItem);
                listOfBooksAddedToShopCard.remove(bookPanel);
                portraitItemsInShopCart.remove(bookPanel);
                portraitItemsInShopCart.updateUI();
                btnOpenShopCart.setText(String.format("%d", listOfBooksAddedToShopCard.size()));
            }
        });
    }
    
    
    

}
