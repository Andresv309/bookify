
package app;

import app.dao.interfaces.AuthorDAO;
import app.models.Author;
import app.dao.exceptions.DAOException;
import app.dao.sqlite.SQLiteDAOManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
        

public class Tests {
    public static void main(String[] args) {
        SQLiteDAOManager prueba = new SQLiteDAOManager();
        
        try {
            AuthorDAO authorDAO = prueba.getAuthorDAO();
            
//            Author author = new Author("Anna");
//            authorDAO.insert(author);
            
            
            List<Author> authorList = authorDAO.getAll();
            System.out.println(authorList);
           
            
        } catch (DAOException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            prueba.closeConnection();
        }
        
        
    }
}
