
package app;

import app.dao.interfaces.AuthorDAO;
import app.models.Category;
import app.dao.interfaces.CategoryDAO;
import app.models.Author;
import app.dao.exceptions.DAOException;
import app.dao.interfaces.CardTypeDAO;
import app.models.CardType;

import app.dao.sqlite.SQLiteDAOManager;
import app.models.connections.DBSQLiteConnection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
        

public class Tests {
    

    
    public static void main(String[] args) throws DAOException {
        
        
//        CategoryDAO categoryDAO = new SQLiteDAOManager().getCategoryDAO();
//        
//        categoryDAO.insert(new Category("hola1"));
//        categoryDAO.insert(new Category("hola2"));
//        categoryDAO.insert(new Category("hola3"));
//        categoryDAO.insert(new Category("hola4"));
//        categoryDAO.insert(new Category("hola5"));
        
        insert(new CardType("C.C"));
        insert(new CardType("T.I."));

//        CardTypeDAO cardTypeDAO = new SQLiteDAOManager().getCardTypeDAO();
//        cardTypeDAO.insert(new Category("C.C"));
//        cardTypeDAO.insert(new Category("T.I."));

//        SQLiteDAOManager prueba = new SQLiteDAOManager();
//        
//        try {
//            AuthorDAO authorDAO = prueba.getAuthorDAO();
//            
////            Author author = new Author("Anna");
////            authorDAO.insert(author);
//            
//            
//            List<Author> authorList = authorDAO.getAll();
//            System.out.println(authorList);
//           
//            
//        } catch (DAOException ex) {
//            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            prueba.closeConnection();
//        }
        System.gc();
        
    }
    
    public static void insert(CardType record) throws DAOException {
        DBSQLiteConnection connInstance = DBSQLiteConnection.getInstance();
        Connection conn = connInstance.getConnection();
        
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement("INSERT INTO cardTypes (type) VALUES (?);");
            stat.setString(1, record.getType());
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
}
