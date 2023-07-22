
package app.dao.sqlite;

import app.dao.interfaces.StockDAO;
import app.models.Stock;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class SQLiteStockDAO implements StockDAO {
    
    private final String INSERT = "INSERT INTO stocks (quantity) VALUES (?);";
    private final String UPDATE = "UPDATE stocks SET quantity = ?, idShelve = ?, idBook = ? WHERE id = ?;";
    private final String DELETE = "DELETE FROM stocks WHERE id = ?;";
    private final String GET = "SELECT id, quantity, idShelve, idBook FROM stocks WHERE id= ?;";
    private final String GETALL = "SELECT id, quantity, idShelve, idBook FROM stocks;";
    
    private Connection conn;
    
    public SQLiteStockDAO(Connection conn) {
        this.conn = conn;
    }
    
    private Stock convert(ResultSet rs) throws SQLException {    
        Long idBook = rs.getLong("idBook");
        Long quantity = rs.getLong("quantity");
        Stock stock = new Stock(idBook, quantity);
        stock.setId(rs.getLong("id"));
        return stock;
    }

    @Override
    public void insert(Stock record) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Stock record) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Long idRecord) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Stock get(Long idRecord) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Stock> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
