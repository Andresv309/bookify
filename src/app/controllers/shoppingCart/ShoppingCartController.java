
package app.controllers.shoppingCart;

import app.controllers.book.*;
import app.controllers.marketplace.MarketplaceController;
import app.dao.DAOManager;
import app.dao.exceptions.DAOException;
import app.dao.interfaces.SaleDAO;
import app.models.Book;
import app.models.CardType;
import app.models.Customer;
import app.models.Sale;
import app.views.shoppingCart.ShoppingCartBookPanel;
import app.views.shoppingCart.ShoppingCartFrame;
import components.mainComponents.swing.PanelBackground;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;


public class ShoppingCartController {
    private ShoppingCartFrame entityFrame;
    private SaleDAO entityDAO;
    
    private BookTableModel entityTableModel;
    private ShoppingCartUserInfoController entityDetailsController;
    
    private PanelBackground detailsPortraitItemsInShopCart;
    private JTextField detailsCardNumber;
    private JComboBox<CardType> detailsCardType;
    private JLabel detailsCustomerName;
    private JLabel detailsTotalPrice;
    private JButton btnConfirmSale;
    private JButton btnConsultClient;
    private JButton btnCleanCart;
    
    private MarketplaceController marketPlaceController;
    private LinkedHashMap<Book, Integer> saleBill = new LinkedHashMap<>();
    private List<ShoppingCartBookPanel> listOfBooksAddedToShopCard;
    
    private Customer customerFound = null;
    
    public ShoppingCartController(ShoppingCartFrame view, MarketplaceController marketPlaceController) throws DAOException {
        DAOManager DAOManager = new DAOManager();
        
        this.marketPlaceController = marketPlaceController;
        
        /*** Specific dao manager ***/
        this.entityDAO = DAOManager.getDAOinstance().getSaleDAO();
        

        this.entityDetailsController = new ShoppingCartUserInfoController(
                view.getDetailsUserInfoShopCartPanel(),
                DAOManager.getDAOinstance().getCardTypeDAO()
        );
        
        /*** Specific table model ***/
//        this.entityTableModel = new BookTableModel(this.entityDAO);
        
        this.entityFrame = view;
        
        this.detailsPortraitItemsInShopCart = entityFrame.getDetailsPortraitItemsInShopCart();
        this.detailsCardNumber = entityFrame.getDetailsUserInfoShopCartPanel().getDetailsCardNumber();
        this.detailsCardType = entityFrame.getDetailsUserInfoShopCartPanel().getDetailsCardType();
        this.detailsCustomerName = entityFrame.getDetailsCustomerName();
        this.detailsTotalPrice = entityFrame.getDetailsTotalPrice();
        this.btnConsultClient = entityFrame.getDetailsBtnConsultClient();
        this.btnConfirmSale = entityFrame.getDetailsBtnConfirmSale();
        this.btnCleanCart = entityFrame.getDetailsBtnCleanCart();

//        this.listOfBooksAddedToShopCard = marketPlaceController.getListOfBooksAddedToShopCard();

        this.initEvents();
    }
    

    public void initEvents() {
        btnConfirmSale.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {  
                    consultAndSaveCustomer();
                try {
                    if (JOptionPane.showConfirmDialog(
                        null,
                        "¿Confirmar Compra?",
                        "Confirmar Compra",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                    ) == JOptionPane.OK_OPTION) {
                        createCustomerBill();
                        saveBill();
                        
                    }
                } catch (DAOException ex) {
                    Logger.getLogger(ShoppingCartController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
//        btnDelete.addActionListener(new ActionListener() {
//            
//            @Override
//            public void actionPerformed(ActionEvent ae) {  
//                if (JOptionPane.showConfirmDialog(
//                        null,
//                        "¿Seguro desea borrar este registro?",
//                        "Borrar Registro",
//                        JOptionPane.YES_NO_OPTION,
//                        JOptionPane.QUESTION_MESSAGE
//                ) == JOptionPane.OK_OPTION) {
//                    try {
//                        Book entity = getRowSelected();
//                        entityDAO.delete(entity.getId());
//                        updatePanelView();
//                        table.clearSelection();
//                        btnEdit.setEnabled(false);
//                        btnDelete.setEnabled(false);
//                        btnSave.setEnabled(false);
//                        btnCancel.setEnabled(false);
//                    } catch (DAOException ex) {
//                        Logger.getLogger(ShoppingCartController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//        });
        
        btnConsultClient.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {  
                consultAndSaveCustomer();
            }
        });
        
        btnCleanCart.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {  
                try {
                    cleanShopCart();
                } catch (ParseException ex) {
                    Logger.getLogger(ShoppingCartController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }  


    private void cleanShopCart() throws ParseException {
        // Clear Customer
        entityDetailsController.resetData();
        
        // Clear shopping cart view, list Of added and list of pair(book: units)
        marketPlaceController.setBooksInShopCart(new ArrayList<>());
        marketPlaceController.setListOfBooksAddedToShopCard(new ArrayList<>());
        saleBill = new LinkedHashMap<>();
        
        PanelBackground shoppingCartPanel = marketPlaceController.getPortraitItemsInShopCart();
        shoppingCartPanel.removeAll();
        shoppingCartPanel.revalidate();
        shoppingCartPanel.repaint();
        
        detailsCustomerName.setText("Nombre Cliente");
        detailsTotalPrice.setText("Total de la Compra");

//        table.clearSelection();
//        btnSave.setEnabled(false);
//        btnCancel.setEnabled(false);
    }
    
//    private void updatePanelView() throws DAOException {
//        infoTag.setText("Actualizando modelo...");
//        entityTableModel.updateView();
//        entityTableModel.fireTableDataChanged();
//        infoTag.setText(Integer.toString(entityTableModel.getRowCount()));
//    } 
    
    private void showCustomerName() throws DAOException {
//        infoTag.setText("Actualizando modelo...");
//        entityTableModel.updateView();
//        entityTableModel.fireTableDataChanged();
//        infoTag.setText(Integer.toString(entityTableModel.getRowCount()));

  
        if (customerFound != null) {
            detailsCustomerName.setText(customerFound.getName());
        } else {
            detailsCustomerName.setText("Usuario NO Registrado");
        }
    } 
    
    public void createCustomerBill() throws DAOException {
        List<ShoppingCartBookPanel> listOfBooksAddedToShopCard = marketPlaceController.getListOfBooksAddedToShopCard();
        BigDecimal totalPrice = new BigDecimal(0);
        
        for (ShoppingCartBookPanel bookPanel: listOfBooksAddedToShopCard) {           
            JSpinner bookItemUnitsSelect = bookPanel.getDetailsItemAmount();
            BigDecimal bookPrice = bookPanel.getBook().getPrice();
            Integer unitsPerItem = 1;
                    
            try {
                bookItemUnitsSelect.commitEdit();
                unitsPerItem = (Integer) bookItemUnitsSelect.getValue();
                System.out.println("unidades por item" + unitsPerItem);
            } catch (NumberFormatException ex) {
                System.out.println("Not valid number");
            } catch (ParseException ex) {
                System.out.println("Not valid number");
            }    
            
            // Doesn't make sense buy 0 books
            if (unitsPerItem < 1) unitsPerItem = 1;
            
            BigDecimal totalPricePerItem = bookPrice.multiply(BigDecimal.valueOf(unitsPerItem));
            System.out.println("Precio por item: " + totalPricePerItem);
            totalPrice = totalPrice.add(totalPricePerItem);
            saleBill.put(bookPanel.getBook(), unitsPerItem);
  
            System.out.println(bookPanel.getBook());
        }
        
        System.out.println(totalPrice);
        detailsTotalPrice.setText(String.format("$ %,.2f", totalPrice));
    }
    
    private void consultAndSaveCustomer() {
        try {
            entityDetailsController.saveData();
            Customer entity = entityDetailsController.getEntity();                           
            customerFound = entityDAO.getCustomer(entity.getIdCardType(), entity.getCardNumber());
            showCustomerName();
//                    cleanSelection();
        } catch (DAOException ex) {
            Logger.getLogger(ShoppingCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void saveBill() throws DAOException {
        if (saleBill.size() > 0) {
            boolean isFirstElement = true;
            Long firstItemInsertedId = null;

            for (Map.Entry<Book, Integer> entry : saleBill.entrySet()) {
                Book book = entry.getKey();
                Integer units = entry.getValue();
                
                for (int index = 0; index < units; index++) {
                    if (isFirstElement && index == 0) {
                        System.out.println("first first");
                        System.out.println(book);
                        System.out.println(units);
                        
                        Sale sale = new Sale(book.getId(), book.getPrice());
                        if (customerFound != null) sale.setIdCustomer(customerFound.getId());

                        firstItemInsertedId = entityDAO.insert(sale);
                        isFirstElement = false;
                    } else {
                        
                        Sale sale = new Sale(book.getId(), book.getPrice());
                        if (customerFound != null) sale.setIdCustomer(customerFound.getId());
                        sale.setIdSaleParent(firstItemInsertedId);
                        entityDAO.insert(sale);
  
                        System.out.println(book);
                        System.out.println(units);
                    }
                }

                
            }
    
//            entityDAO.insert(record);
        }
    }
    
    
    
//    public void recalculatePrice() {

//    }
//    
    
}
