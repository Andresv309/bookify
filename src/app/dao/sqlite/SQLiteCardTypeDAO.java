package app.dao.sqlite;

import app.dao.interfaces.CardTypeDAO;
import app.dao.exceptions.DAOException;
import app.models.CardType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


public class SQLiteCardTypeDAO implements CardTypeDAO {
    
    private final String GET = "SELECT id, type FROM cardTypes WHERE id = ?;";
    private final String GETALL = "SELECT id, type FROM cardTypes;";
    
    private Connection conn;
    
    public SQLiteCardTypeDAO(Connection conn) {
        this.conn = conn;
    }
    
    private CardType convert(ResultSet rs) throws SQLException {
        String type = rs.getString("type");
        CardType cardType = new CardType(type);
        cardType.setId(rs.getLong("id"));
        return cardType;
    }
    
    @Override
    public CardType get(Long idRecord) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        CardType cardtype = null;
        try {
            stat = conn.prepareStatement(GET);
            stat.setLong(1, idRecord);
            rs = stat.executeQuery();
            if (rs.next()) {
                cardtype = convert(rs);
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
        
        return cardtype;
    }

    @Override
    public List<CardType> getAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<CardType> cardtypeList = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                cardtypeList.add(convert(rs));
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
        
        return cardtypeList;
    
    }
    
}
