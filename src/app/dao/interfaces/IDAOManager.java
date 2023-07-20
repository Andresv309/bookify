
package app.dao.interfaces;


public interface IDAOManager {
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
