
package app.dao;

import app.dao.exceptions.DAOException;
import java.util.List;
import app.models.CardType;


public interface CardTypeDAO {
    CardType get(Long idRecord) throws DAOException;
    List<CardType> getAll() throws DAOException; 
}
