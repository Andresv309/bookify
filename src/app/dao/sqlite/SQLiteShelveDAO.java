
package app.dao.sqlite;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.ShelveDAO;
import app.models.Shelve;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SQLiteShelveDAO implements ShelveDAO {
    
    
    private final String INSERT = "INSERT INTO shelves (name) VALUES (?);";
    private final String UPDATE = "UPDATE shelves SET name = ? WHERE id = ?;";
    private final String DELETE = "DELETE FROM shelves WHERE id = ?;";
    private final String GET = "SELECT id, name FROM shelves WHERE id = ?;";
    private final String GETALL = "SELECT id, name FROM shelves;";
    
    private Connection conn;
    
    public SQLiteShelveDAO(Connection conn) {
        this.conn = conn;
    }
    
    private Shelve convert(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        Shelve shelve = new Shelve(name);
        shelve.setId(rs.getLong("id"));
        return shelve;
    }
    
    @Override
    public void insert(Shelve record) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, record.getName());
            if (stat.executeUpdate() == 0) {
                throw new DAOException("Record might not have been saved.");
            }
            
            rs = stat.getGeneratedKeys();
            if (rs.next()) {
                rs.getLong(1);
            } else {
                throw new DAOException("Couldn't assign id to record.");
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
                    throw new DAOException("SQL Error.", ex);
                }
            }
        }
    }

    @Override
    public void update(Shelve record) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setLong(2, record.getId());
            stat.setString(1, record.getName());
            if (stat.executeUpdate() == 0) {
                throw new DAOException("Record id not found.");
            }
        } catch (SQLException ex) {
            throw new DAOException("SQL Error.", ex);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("SQL Error.", ex);
                }
            }
        }
    }

    @Override
    public void delete(Long idRecord) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, idRecord);
            if (stat.executeUpdate() == 0) {
                throw new DAOException("Record id not found.");
            }
        } catch (SQLException ex) {
            throw new DAOException("SQL Error.", ex);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("SQL Error.", ex);
                }
            }
        }
    }

    @Override
    public Shelve get(Long idRecord) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Shelve shelve = null;
        try {
            stat = conn.prepareStatement(GET);
            stat.setLong(1, idRecord);
            rs = stat.executeQuery();
            if (rs.next()) {
                shelve = convert(rs);
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
        
        return shelve;
    }

    @Override
    public List<Shelve> getAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Shelve> shelveList = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                shelveList.add(convert(rs));
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
        
        return shelveList;
    }
    
}
