
package app.dao.sqlite;

import app.dao.interfaces.SaleItemsDAO;
import app.dao.exceptions.DAOException;
import java.sql.PreparedStatement;
import app.models.SaleItems;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SQLiteSaleItemsDAO implements SaleItemsDAO {
    
    
    private final String INSERT = "INSERT INTO saleItems (idSale) VALUES (?);";
    private final String GET = "SELECT id, idSale,idBook FROM saleItems WHERE id = ?;";
    private final String GETALL = "SELECT id, idSale,idBook FROM saleItems;";
    
    private Connection conn;
    
    public SQLiteSaleItemsDAO(Connection conn) {
        this.conn = conn;
    }
    
    private SaleItems convert(ResultSet rs) throws SQLException {
        Long idSale = rs.getLong("idSale");
        Long idBook = rs.getLong("idBook");
        SaleItems saleItems = new SaleItems(idSale,idBook);
        saleItems.setId(rs.getLong("id"));
        return saleItems;
    }
    
    
    @Override
    public void insert(Long record) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SaleItems get(Long idSale) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        SaleItems saleitems = null;
        try {
            stat = conn.prepareStatement(GET);
            stat.setLong(1, idSale);
            rs = stat.executeQuery();
            if (rs.next()) {
                saleitems = convert(rs);
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
        
        return saleitems;
    }

    @Override
    public List<SaleItems> getAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<SaleItems> saleItemsList = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                saleItemsList.add(convert(rs));
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
        
        return saleItemsList;
    }
    
}
