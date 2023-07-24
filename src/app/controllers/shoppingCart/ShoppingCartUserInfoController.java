
package app.controllers.shoppingCart;

import app.controllers.customer.CustomerCardTypeComboBoxModel;
import app.dao.exceptions.DAOException;
import app.dao.interfaces.CardTypeDAO;
import app.models.CardType;
import app.models.Customer;
import app.views.shoppingCart.ShoppingCartUserInfoPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;


public class ShoppingCartUserInfoController {
    private ShoppingCartUserInfoPanel entityDetailsPanel;
    private Customer entity;
    
    private CustomerCardTypeComboBoxModel cardTypeComboBoxModel;
    
    private JTextField detailsCardNumber;   
    private JComboBox<CardType> detailsCardType;

    public ShoppingCartUserInfoController(ShoppingCartUserInfoPanel entityDetailsPanel, CardTypeDAO cardTypeDAO) throws DAOException {
        this.entityDetailsPanel = entityDetailsPanel;
        
        this.cardTypeComboBoxModel = new CustomerCardTypeComboBoxModel(cardTypeDAO);
        
        this.detailsCardNumber = entityDetailsPanel.getDetailsCardNumber();
        this.detailsCardType = entityDetailsPanel.getDetailsCardType();
        
        this.detailsCardType.setModel(cardTypeComboBoxModel);
    }

    public Customer getEntity() {
        return entity;
    }

    public void setEntity(Customer entity) {
        this.entity = entity;
    }
    
    public void resetData() {
        if (entity == null) {
            entity = new Customer("", 0L, "");
        }
        detailsCardNumber.setText("");
        detailsCardType.setSelectedIndex(0);
    }
    
    
    public void saveData() {
        if (entity == null) {
            entity = new Customer("", 0L, "");
        }
        CardType cardType = (CardType) cardTypeComboBoxModel.getSelectedItem();
        entity.setCardNumber(detailsCardNumber.getText());
        entity.setIdCardType(cardType.getId());
        entity.setCardType(cardType.getType());
    }

    public CustomerCardTypeComboBoxModel getCardTypeComboBoxModel() {
        return cardTypeComboBoxModel;
    }

    public void setCardTypeComboBoxModel(CustomerCardTypeComboBoxModel cardTypeComboBoxModel) {
        this.cardTypeComboBoxModel = cardTypeComboBoxModel;
        detailsCardType.setModel(cardTypeComboBoxModel);
    }    
}
