
package app.dao;


public interface DAOManager {
    AuthorDAO getAuthorDAO();
    BookDAO getBookDAO();
    CategoryDAO getCategoryDAO ();
    CustomerDAO getCustomerDAO();
    SaleDAO getSaleDAO();
    ShelveDAO getShelveDAO();
    StockDAO getStockDAO();
    CardTypeDAO getCardTypeDAO();
    SaleItemsDAO getSaleItemsDAO();
    UserDAO getUserDao();
}
