
package app.dao;

import app.dao.exceptions.DAOException;
import java.util.List;
import app.models.User;


public interface UserDAO {
    User get(Long idRecord) throws DAOException;
    List<User> getAll() throws DAOException;
}
