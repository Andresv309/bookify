
package app.dao;

import app.dao.exceptions.DAOException;
import java.util.List;
import app.models.SaleItems;


public interface SaleItemsDAO {
    void insert(Long record) throws DAOException;
    SaleItems get(Long idSale) throws DAOException;
    List<SaleItems> getAll() throws DAOException;
}
