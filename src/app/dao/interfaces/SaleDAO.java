
package app.dao.interfaces;
import app.dao.exceptions.DAOException;
import app.models.Sale;
import app.models.Customer;
import java.math.BigDecimal;
import java.util.List;


public interface SaleDAO {
    long insert(Sale record) throws DAOException;
    Sale get(Long idRecord) throws DAOException;
    List<Sale> getAll() throws DAOException;
    int getSalesCount() throws DAOException;
    BigDecimal getProfits() throws DAOException;
    Customer getCustomer(Long cardTypeId, String cardNumber)throws DAOException;
}
