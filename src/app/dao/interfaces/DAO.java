
package app.dao.interfaces;

import app.dao.exceptions.DAOException;
import java.util.List;


public interface DAO<T, K> {
    void insert(T record) throws DAOException;
    void update(T record) throws DAOException;
    void delete(K idRecord) throws DAOException;
    T get(K idRecord) throws DAOException;
    List<T> getAll() throws DAOException;
}
