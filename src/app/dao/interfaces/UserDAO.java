
package app.dao.interfaces;

import app.dao.exceptions.DAOException;
import java.util.List;
import app.models.User;


public interface UserDAO {
    User get(Long idRecord) throws DAOException;
    List<User> getAll() throws DAOException;
    User valitate(String username, String password) throws DAOException;
}
