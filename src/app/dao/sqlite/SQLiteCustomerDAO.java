
package app.dao.sqlite;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.CustomerDAO;
import app.models.Customer;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SQLiteCustomerDAO implements CustomerDAO {
    
    private final String INSERT = "INSERT INTO customers (name, idCardType, cardNumber) VALUES (?, ?, ?);";
    private final String UPDATE = "UPDATE customers SET name = ?, idCardType = ?, cardNumber = ? WHERE id = ?;";
    private final String DELETE = "DELETE FROM customers WHERE id = ?;";
    private final String SELECT = "SELECT id, name, idCardType, cardNumber, createdAt ";
    private final String GET = SELECT + "FROM customers WHERE id= ?;";
    private final String GETALL = SELECT + "FROM customers;";
    
    private final String SELECTJOIN = "SELECT "
            + "c.id as id, "
            + "c.name as name, "
            + "c.idCardType as idCardType, "
            + "c.cardNumber as cardNumber, "
            + "c.createdAt as createdAt, "
            + "ct.type as CardTypesType ";
    private final String FROMJOIN = "FROM customers as c INNER JOIN cardTypes as ct ON c.idCardType = ct.id ";
    private final String GETJOIN = SELECTJOIN + FROMJOIN + "WHERE c.id= ?;";
    private final String GETJOINALL = SELECTJOIN + FROMJOIN + ";";
    
    private Connection conn;
    
    public SQLiteCustomerDAO(Connection conn) {
        this.conn = conn;
    }
    
    private Customer convert(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        Long idCardType = rs.getLong("idCardType");
        String cardNumber = rs.getString("cardNumber");
        String createdAt = rs.getString("createdAt");
        String CardTypesType = rs.getString("CardTypesType");

        
        Customer customer = new Customer(name, idCardType, cardNumber);
        customer.setId(rs.getLong("id"));
        customer.setCreatedAt(createdAt);
        customer.setCardType(CardTypesType);
        return customer;
    }
    
    
    @Override
    public void insert(Customer record) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, record.getName());
            stat.setLong(2, record.getIdCardType());
            stat.setString(3,record.getCardNumber());
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
    public void update(Customer record) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setLong(4, record.getId());
            stat.setString(1, record.getName());
            stat.setLong(2, record.getIdCardType());
            stat.setString(3,record.getCardNumber());
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
    public Customer get(Long idRecord) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Customer customer = null;
        try {
            stat = conn.prepareStatement(GETJOIN);
            stat.setLong(1, idRecord);
            rs = stat.executeQuery();
            if (rs.next()) {
                customer = convert(rs);
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
        
        return customer;
    }

    @Override
    public List<Customer> getAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Customer> customerList = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETJOINALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                customerList.add(convert(rs));
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
        
        return customerList;
    }
    
}
