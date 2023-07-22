
package app.dao.sqlite;

import app.dao.interfaces.AuthorDAO;
import app.dao.interfaces.BookDAO;
import app.dao.interfaces.CardTypeDAO;
import app.dao.interfaces.CategoryDAO;
import app.dao.interfaces.CustomerDAO;
import app.dao.interfaces.SaleDAO;
import app.dao.interfaces.SaleItemsDAO;
import app.dao.interfaces.ShelveDAO;
import app.dao.interfaces.StockDAO;
import app.dao.interfaces.UserDAO;
import app.models.connections.DBSQLiteConnection;
import java.sql.Connection;
import app.dao.interfaces.IDAOManager;


public class SQLiteDAOManager implements IDAOManager{
    private DBSQLiteConnection connInstance;
    private Connection conn;
    
    private AuthorDAO author = null;
    private BookDAO book = null;
    private CategoryDAO category = null;
    private CustomerDAO customer = null;
    private SaleDAO sale = null;
    private ShelveDAO shelve = null;
    private StockDAO stock = null;
    private CardTypeDAO cardType = null;
    private SaleItemsDAO saleItems = null;
    private UserDAO user = null;
    
    public SQLiteDAOManager () {
        this.connInstance = DBSQLiteConnection.getInstance();
        this.conn = connInstance.getConnection();
    }
    
    public void closeConnection() {
        connInstance.closeConnection();
    }

    @Override
    public AuthorDAO getAuthorDAO() {
        if (author == null) {
            author = new SQLiteAuthorDAO(conn);
        }
        return author;
    }

    @Override
    public BookDAO getBookDAO() {
        if (book == null) {
            book = new SQLiteBookDAO(conn);
        }
        return book;
    }

    @Override
    public CategoryDAO getCategoryDAO() {
        if (category == null) {
            category = new SQLiteCategoryDAO(conn);
        }
        return category;
    }

    @Override
    public CustomerDAO getCustomerDAO() {
        if (customer == null) {
            customer = new SQLiteCustomerDAO(conn);
        }
        return customer;
    }

    @Override
    public SaleDAO getSaleDAO() {
        if (sale == null) {
            sale = new SQLiteSaleDAO();
        }
        return sale;
    }

    @Override
    public ShelveDAO getShelveDAO() {
        if (shelve == null) {
            shelve = new SQLiteShelveDAO(conn);
        }
        return shelve;
    }

    @Override
    public StockDAO getStockDAO() {
        if (stock == null) {
            stock = new SQLiteStockDAO(conn);
        }
        return stock;
    }

    @Override
    public CardTypeDAO getCardTypeDAO() {
        if (cardType == null) {
            cardType = new SQLiteCardTypeDAO(conn);
        }
        return cardType;
    }

    @Override
    public SaleItemsDAO getSaleItemsDAO() {
        if (saleItems == null) {
            saleItems = new SQLiteSaleItemsDAO(conn);
        }
        return saleItems;
    }

    @Override
    public UserDAO getUserDao() {
        if (user == null) {
            user = new SQLiteUserDAO();
        }
        return user;
    }
}
