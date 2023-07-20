
package app.dao.sqlite;

import app.dao.UserDAO;
import app.dao.exceptions.DAOException;
import app.models.User;
import java.util.List;


public class SQLiteUserDAO implements UserDAO {

    @Override
    public User get(Long idRecord) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<User> getAll() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
