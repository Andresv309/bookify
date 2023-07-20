
package app.dao.sqlite;

import app.dao.interfaces.CardTypeDAO;
import app.dao.exceptions.DAOException;
import app.models.CardType;
import java.util.List;


public class SQLiteCardTypeDAO implements CardTypeDAO {

    @Override
    public CardType get(Long idRecord) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CardType> getAll() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
