
package app.dao.interfaces;
import app.dao.exceptions.DAOException;
import app.models.Stock;
import java.util.List;


public interface StockDAO {
    void update(Stock record) throws DAOException;
    Stock get(Long idRecord) throws DAOException;
    List<Stock> getAll() throws DAOException;
}
