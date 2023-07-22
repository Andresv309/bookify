
package app.dao.sqlite;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.StockDAO;
import app.models.Stock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SQLiteStockDAO implements StockDAO {
    
    private final String UPDATE = "UPDATE stocks SET quantity = ? WHERE id = ?;";
    private final String GET = "SELECT id, quantity, idShelve, idBook FROM stocks WHERE id= ?;";
    private final String GETALL = "SELECT id, quantity, idShelve, idBook FROM stocks;";
    
    private final String SELECTJOIN = "SELECT "
            + "st.id as id, "
            + "st.quantity as quantity, "
            + "st.idShelve as idShelve, "
            + "st.idBook as idBook, "
            + "sh.name as shelveName, "
            + "b.name as bookName ";
    private final String FROMJOIN = "FROM stocks as st INNER JOIN shelves as sh ON st.idShelve = sh.id INNER JOIN books AS b ON st.idBook = b.id";
    private final String GETJOIN = SELECTJOIN + FROMJOIN + "WHERE c.id= ?;";
    private final String GETJOINALL = SELECTJOIN + FROMJOIN + ";";
    
    
    private Connection conn;
    
    public SQLiteStockDAO(Connection conn) {
        this.conn = conn;
    }
    
    private Stock convert(ResultSet rs) throws SQLException {    
        Long quantity = rs.getLong("quantity");
        Stock stock = new Stock(quantity);
        stock.setId(rs.getLong("id"));
        stock.setIdBook(rs.getLong("idBook"));
        stock.setIdShelve(rs.getLong("idShelve"));
        stock.setShelveName(rs.getString("shelveName"));
        stock.setBookName(rs.getString("bookName"));
        
        return stock;
    }


    @Override
    public void update(Stock record) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setLong(2, record.getId());
            stat.setLong(1, record.getQuantity());
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
    public Stock get(Long idRecord) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Stock stock = null;
        try {
            stat = conn.prepareStatement(GETJOIN);
            stat.setLong(1, idRecord);
            rs = stat.executeQuery();
            if (rs.next()) {
                stock = convert(rs);
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
        
        return stock;
    }

    @Override
    public List<Stock> getAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Stock> stockList = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETJOINALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                stockList.add(convert(rs));
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
        
        return stockList;
    }
    
}
