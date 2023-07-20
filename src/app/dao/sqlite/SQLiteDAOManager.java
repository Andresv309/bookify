
package app.dao.sqlite;

import app.dao.AuthorDAO;
import app.dao.BookDAO;
import app.dao.CardTypeDAO;
import app.dao.CategoryDAO;
import app.dao.CustomerDAO;
import app.dao.DAOManager;
import app.dao.SaleDAO;
import app.dao.SaleItemsDAO;
import app.dao.ShelveDAO;
import app.dao.StockDAO;
import app.dao.UserDAO;
import app.models.connections.DBSQLiteConnection;
import java.sql.Connection;


public class SQLiteDAOManager implements DAOManager{
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
        this.conn = DBSQLiteConnection.getInstance().getConnection();
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
            book = new SQLiteBookDAO();
        }
        return book;
    }

    @Override
    public CategoryDAO getCategoryDAO() {
        if (category == null) {
            category = new SQLiteCategoryDAO();
        }
        return category;
    }

    @Override
    public CustomerDAO getCustomerDAO() {
        if (customer == null) {
            customer = new SQLiteCustomerDAO();
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
            shelve = new SQLiteShelveDAO();
        }
        return shelve;
    }

    @Override
    public StockDAO getStockDAO() {
        if (stock == null) {
            stock = new SQLiteStockDAO();
        }
        return stock;
    }

    @Override
    public CardTypeDAO getCardTypeDAO() {
        if (cardType == null) {
            cardType = new SQLiteCardTypeDAO();
        }
        return cardType;
    }

    @Override
    public SaleItemsDAO getSaleItemsDAO() {
        if (saleItems == null) {
            saleItems = new SQLiteSaleItemsDAO();
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
