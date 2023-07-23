
package app.controllers.profits;

import app.dao.DAOManager;
import app.dao.exceptions.DAOException;
import app.dao.interfaces.BookDAO;
import app.dao.interfaces.SaleDAO;
import app.dao.interfaces.StockDAO;
import app.views.profits.ProfitsPanel;
import app.models.Sale;
import app.views.profits.Card;
import java.math.BigDecimal;


public class ProfitsController {
    private ProfitsPanel entityPanel;
    
    private SaleDAO saleDAO;
    private BookDAO bookDAO;
    private StockDAO stockDAO;
   
    private Card card1;
    private Card card2;
    private Card card3;
    
    int salesCount = 0;
    BigDecimal salesProfit = new BigDecimal(0);
    int stockCount = 0;

    
    public ProfitsController(ProfitsPanel view) throws DAOException {
        DAOManager DAOManager = new DAOManager();
        
        /*** Specific dao manager ***/
        this.saleDAO = DAOManager.getDAOinstance().getSaleDAO();
        this.bookDAO = DAOManager.getDAOinstance().getBookDAO();
        this.stockDAO = DAOManager.getDAOinstance().getStockDAO();
        
        this.entityPanel = view;
        
        this.card1 = entityPanel.getCard1();
        this.card2 = entityPanel.getCard2();
        this.card3 = entityPanel.getCard3();

        this.updatePanelView();
    }
     
    private void updatePanelView() throws DAOException {
        fetchSalesCount();
        fetchProfit();
        fetchStockCountForAllBooks();
        
        card1.getLbTitle().setText("No. de Ventas");
        card1.getLbDescription().setText("La cantidad recibos generados.");
        card1.getLbValues().setText(Integer.toString(salesCount));
        
        card2.getLbTitle().setText("Ganancias");
        card2.getLbDescription().setText("Tus ingresos por ventas.");
        card2.getLbValues().setText(String.format("$ %,.2f",salesProfit));
        
        card3.getLbTitle().setText("No. de libros en stock");
        card3.getLbDescription().setText("La suma de todos los libros.");
        card3.getLbValues().setText(Integer.toString(stockCount));
  
    }
    
    public void fetchSalesCount() throws DAOException {
        salesCount = saleDAO.getSalesCount();
    }
    
    public void fetchProfit() throws DAOException {
        salesProfit = saleDAO.getProfits();
    }
    
    public void fetchStockCountForAllBooks() throws DAOException {
        stockCount = stockDAO.getStockCountForAllBooks();
    }
}
