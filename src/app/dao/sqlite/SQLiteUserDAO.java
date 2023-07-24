
package app.dao.sqlite;

import app.dao.interfaces.UserDAO;
import app.dao.exceptions.DAOException;
import app.models.User;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SQLiteUserDAO implements UserDAO {

    private final String GET = "SELECT id, username, password FROM users WHERE id = ?;";
    private final String GETALL = "SELECT id, username, password FROM users;";
    private final String GETVALIDATION = "SELECT id, username, password FROM users WHERE username = ? AND password = ?;";
    
    
    private Connection conn;
    
    public SQLiteUserDAO(Connection conn) {
        this.conn = conn;
    }
    
    private User convert(ResultSet rs) throws SQLException {
        String username = rs.getString("username");
        String password = rs.getString("password");
        User author = new User(username, password);
        author.setId(rs.getLong("id"));
        return author;
    }
    
    @Override
    public User get(Long idRecord) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        User user = null;
        try {
            stat = conn.prepareStatement(GET);
            stat.setLong(1, idRecord);
            rs = stat.executeQuery();
            if (rs.next()) {
                user = convert(rs);
            } else {
                throw new DAOException("Record id not found.");
            }
        } catch (SQLException ex) {
            throw new DAOException("SQL Error.", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Couldn't close resultSet.", ex);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Couldn't close prepareStatement.", ex);
                }
            }
        }
        
        return user;
    }

    @Override
    public List<User> getAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<User> usersList = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                usersList.add(convert(rs));
            }
        } catch (SQLException ex) {
            throw new DAOException("SQL Error.", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Couldn't close resultSet.", ex);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Couldn't close prepareStatement.", ex);
                }
            }
        }
        
        return usersList;
    }

    @Override
    public User valitate(String username, String password) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        User user = null;
        try {
            stat = conn.prepareStatement(GETVALIDATION);
            stat.setString(1, username);
            stat.setString(2, password);
            rs = stat.executeQuery();
            if (rs.next()) {
                user = convert(rs);
            }
        } catch (SQLException ex) {
            throw new DAOException("SQL Error.", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Couldn't close resultSet.", ex);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Couldn't close prepareStatement.", ex);
                }
            }
        }
        
        return user;
    }
    
}
