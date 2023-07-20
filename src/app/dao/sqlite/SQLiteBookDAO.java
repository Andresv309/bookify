
package app.dao.sqlite;

import app.dao.interfaces.BookDAO;
import app.models.Book;
import java.util.List;


public class SQLiteBookDAO implements BookDAO {

    private final String INSERT = "";
    private final String UPDATE = "";
    private final String DELETE = "";
    private final String GET = "";
    private final String GETALL = "";
        
    public SQLiteBookDAO () {
        
    }
    
    
    @Override
    public void insert(Book record) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Book record) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Long idRecord) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Book get(Long idRecord) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Book> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
