
package app.dao.sqlite;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.BookDAO;
import app.models.Book;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SQLiteBookDAO implements BookDAO {

    private final String INSERT = "INSERT INTO books (name, description, price, idCategory, idAuthor, imgPath) VALUES (?, ?, ?, ?, ?, ?);";
    private final String UPDATE = "UPDATE books SET name = ?, description = ?, price = ?, idCategory = ?, idAuthor = ?, imgPath = ? WHERE id = ?;";
    private final String DELETE = "DELETE FROM books WHERE id = ?;";
    private final String SELECT = "SELECT id, name, description, price, idCategory, idAuthor,imgPath ";
    private final String GET = SELECT + "FROM books WHERE id= ?;";
    private final String GETALL = SELECT + "FROM books;";
    
    private final String SELECTJOIN = "SELECT "
            + "b.id as id, "
            + "b.name as name, "
            + "b.description as description, "
            + "b.price as price, "
            + "b.idCategory as idCategory, "
            + "b.idAuthor as idAuthor, "
            + "b.imgPath as imgPath, "
            + "c.name as categoryName, "
            + "a.name as authorName ";
    private final String FROMJOIN = "FROM books as b INNER JOIN categories as c ON b.idCategory = c.id INNER JOIN authors as a ON b.idAuthor = a.id ";
    private final String GETJOIN = SELECTJOIN + FROMJOIN + "WHERE b.id= ?;";
    private final String GETJOINALL = SELECTJOIN + FROMJOIN + ";";
    
    private Connection conn;
    
    public SQLiteBookDAO(Connection conn) {
        this.conn = conn;
    }
    
    private Book convert(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String description = rs.getString("description");
        BigDecimal price = rs.getBigDecimal("price");
        Long idCategory = rs.getLong("idCategory");
        Long idAuthor = rs.getLong("idAuthor");
        String categoryName = rs.getString("categoryName");
        String authorName = rs.getString("authorName");
        String imgPath = rs.getString("imgPath");
        
        Book book = new Book(name, description, price, idCategory, idAuthor, imgPath);
        book.setId(rs.getLong("id"));
        book.setCategoryName(categoryName);
        book.setAuthorName(authorName);
        return book;
    }
    
    
    @Override
    public void insert(Book record) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, record.getName());
            stat.setString(2, record.getDescription());
            stat.setBigDecimal(3,record.getPrice());
            stat.setLong(4,record.getIdCategory());
            stat.setLong(5,record.getIdAuthor());
            stat.setString(6,record.getImgPath());
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
    public void update(Book record) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setLong(7, record.getId());
            stat.setString(1, record.getName());
            stat.setString(2, record.getDescription());
            stat.setBigDecimal(3, record.getPrice());
            stat.setLong(4, record.getIdCategory());
            stat.setLong(5, record.getIdAuthor());
            stat.setString(6, record.getImgPath());
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
    public Book get(Long idRecord) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Book book = null;
        try {
            stat = conn.prepareStatement(GETJOIN);
            stat.setLong(1, idRecord);
            rs = stat.executeQuery();
            if (rs.next()) {
                book = convert(rs);
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
        
        return book;
    }

    @Override
    public List<Book> getAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Book> bookList = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETJOINALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                bookList.add(convert(rs));
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
        
        return bookList;
    }
    
}
