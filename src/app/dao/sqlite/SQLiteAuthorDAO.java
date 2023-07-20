
package app.dao.sqlite;

import app.dao.interfaces.AuthorDAO;
import app.dao.exceptions.DAOException;
import app.models.Author;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;


public class SQLiteAuthorDAO implements AuthorDAO {

    private final String INSERT = "INSERT INTO authors (name) VALUES (?);";
    private final String UPDATE = "UPDATE authors SET name = ? WHERE id = ?;";
    private final String DELETE = "DELETE FROM authors WHERE id = ?;";
    private final String GET = "SELECT id, name FROM authors WHERE id = ?;";
    private final String GETALL = "SELECT id, name FROM authors;";
    
    private Connection conn;
    
    public SQLiteAuthorDAO(Connection conn) {
        this.conn = conn;
    }
    
    private Author convert(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        Author author = new Author(name);
        author.setId(rs.getLong("id"));
        return author;
    }
    
    
    @Override
    public void insert(Author record) throws DAOException {
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
    public void update(Author record) throws DAOException {
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
    public Author get(Long idRecord) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Author author = null;
        try {
            stat = conn.prepareStatement(GET);
            stat.setLong(1, idRecord);
            rs = stat.executeQuery();
            if (rs.next()) {
                author = convert(rs);
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
        
        return author;
    }

    @Override
    public List<Author> getAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Author> authorsList = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                authorsList.add(convert(rs));
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
        
        return authorsList;
    }
    
}
