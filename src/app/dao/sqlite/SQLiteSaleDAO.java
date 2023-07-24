
package app.dao.sqlite;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.SaleDAO;
import app.models.Customer;
import app.models.Sale;
import java.math.BigDecimal;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SQLiteSaleDAO implements SaleDAO {

    private final String INSERT = "INSERT INTO sales (idBook, idCustomer, salePrice, idSaleParent) VALUES (?, ?, ?, ?);";
    private final String SELECT = "SELECT id, idBook, idCustomer, salePrice, idSaleParent, createdAt ";
    private final String GET = SELECT + "FROM sales WHERE id= ?;";
    private final String GETALL = SELECT + "FROM sales;";
    
    private final String SELECTJOIN = "SELECT "
            + "s.id as id, "
            + "s.idBook as idBook, "
            + "s.idCustomer as idCustomer, "
            + "s.salePrice as salePrice, "
            + "s.idSaleParent as idSaleParent, "
            + "s.createdAt as createdAt, "
            + "c.name as customerName, "
            + "b.name as bookName ";
    private final String FROMJOIN = "FROM sales as s INNER JOIN customers as c ON s.idCustomer = c.id INNER JOIN books as b ON s.idBook = b.id ";
    private final String GETJOIN = SELECTJOIN + FROMJOIN + "WHERE s.id= ?;";
    private final String GETJOINALL = SELECTJOIN + FROMJOIN + ";";
    
    private final String GETCOUNT = "SELECT COUNT(*) as count FROM sales WHERE idSaleParent IS NULL;";
    private final String GETPROFIT = "SELECT SUM(salePrice) as profit FROM sales;";
    
    private final String GETCUSTOMER = "SELECT id, name, idCardType, cardNumber FROM customers WHERE idCardType = ? AND cardNumber = ?;";
  
    private Connection conn;
    
    public SQLiteSaleDAO(Connection conn) {
        this.conn = conn;
    }
    
    private Sale convert(ResultSet rs) throws SQLException {
        Long idBook = rs.getLong("idBook");
        Long idCustomer = rs.getLong("idCustomer");
        BigDecimal salePrice = rs.getBigDecimal("salePrice");
        Long idSaleParent = rs.getLong("idSaleParent");
        String createdAt = rs.getString("createdAt");
        String customerName = rs.getString("customerName");
        String bookName = rs.getString("bookName");
        
        Sale sale = new Sale(idBook, salePrice);
        sale.setIdCustomer(idCustomer);
        sale.setIdSaleParent(idSaleParent);
        sale.setCreatedAt(createdAt);
        sale.setCustomerName(customerName);
        sale.setBookName(bookName);

        return sale;
    }
    
    
    @Override
    public long insert(Sale record) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            boolean hasRegisteredCostumerId = record.getIdCustomer() != null;
            boolean hasParentSaleId = record.getIdSaleParent() != null;

            stat = conn.prepareStatement(INSERT);
            stat.setLong(1, record.getIdBook());         
            stat.setBigDecimal(3,record.getSalePrice());
            
            if (hasRegisteredCostumerId) stat.setLong(2, record.getIdCustomer());
            if (hasParentSaleId) stat.setLong(4,record.getIdSaleParent());
            
            if (stat.executeUpdate() == 0) {
                throw new DAOException("Record might not have been saved.");
            }
            
            rs = stat.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
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
    public Sale get(Long idRecord) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Sale book = null;
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
    public List<Sale> getAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Sale> salesList = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETJOINALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                salesList.add(convert(rs));
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
        
        return salesList;
    }
    
    
    public int getSalesCount() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        int count = 0;
        try {
            stat = conn.prepareStatement(GETCOUNT);
            rs = stat.executeQuery();
             if (rs.next()) {
                count = rs.getInt("count");
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
        
        return count;
    }

    @Override
    public BigDecimal getProfits() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        BigDecimal profit = new BigDecimal(0);
        try {
            stat = conn.prepareStatement(GETPROFIT);
            rs = stat.executeQuery();
             if (rs.next()) {
                profit = rs.getBigDecimal("profit");
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
        
        return profit;
    }

    private Customer convertCustomer(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        Long idCardType = rs.getLong("idCardType");
        String cardNumber = rs.getString("cardNumber");

        Customer customer = new Customer(name, idCardType, cardNumber);
        customer.setId(rs.getLong("id"));
        return customer;
    }
    
    
    
    @Override
    public Customer getCustomer(Long cardTypeId, String cardNumber) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Customer customer = null;
        try {
            stat = conn.prepareStatement(GETCUSTOMER);
            stat.setLong(1, cardTypeId);
            stat.setString(2, cardNumber);
            rs = stat.executeQuery();
            if (rs.next()) {
                customer = convertCustomer(rs);
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
        
        return customer;
    }
}
