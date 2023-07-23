
package app.dao.interfaces;
import app.dao.exceptions.DAOException;
import app.models.Sale;
import java.math.BigDecimal;
import java.util.List;


public interface SaleDAO {
    void insert(Sale record) throws DAOException;
    Sale get(Long idRecord) throws DAOException;
    List<Sale> getAll() throws DAOException;
    int getSalesCount() throws DAOException;
    BigDecimal getProfits() throws DAOException;
}
