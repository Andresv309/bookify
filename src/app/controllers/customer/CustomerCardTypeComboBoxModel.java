
package app.controllers.customer;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.CardTypeDAO;
import app.models.CardType;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;


public class CustomerCardTypeComboBoxModel extends DefaultComboBoxModel<CardType>{
    private CardTypeDAO cardTypeDAO;
    private List<CardType> cardTypeSelectData = new ArrayList<>();

    public CustomerCardTypeComboBoxModel(CardTypeDAO cardTypeDAO) throws DAOException {
        this.cardTypeDAO = cardTypeDAO;
        update();
    }
    
    public void update() throws DAOException {
        if (cardTypeDAO != null) {
            cardTypeSelectData = cardTypeDAO.getAll();
            removeAllElements();
            for (CardType cardType : cardTypeSelectData) {
                addElement(cardType);
            }
        }
    }
    
}
