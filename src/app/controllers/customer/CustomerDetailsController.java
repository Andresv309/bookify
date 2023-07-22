
package app.controllers.customer;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.CardTypeDAO;
import app.models.CardType;
import app.views.customer.CustomerDetailsPanel;
import app.models.Customer;
import java.util.Objects;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;


public class CustomerDetailsController {
    private boolean editable;
    private CustomerDetailsPanel entityDetailsPanel;
    private Customer entity;
    
    private CustomerCardTypeComboBoxModel cardTypeComboBoxModel;
    
    private JTextField detailsName;   
    private JComboBox<CardType> detailsCardType;   
    private JFormattedTextField detailsCardNumber;   

    public CustomerDetailsController(CustomerDetailsPanel entityDetailsPanel, CardTypeDAO cardTypeDAO) throws DAOException {
        this.entityDetailsPanel = entityDetailsPanel;
        
        this.cardTypeComboBoxModel = new CustomerCardTypeComboBoxModel(cardTypeDAO);
        
        this.detailsName = entityDetailsPanel.getDetailsName();
        this.detailsCardType = entityDetailsPanel.getDetailsCardType();
        this.detailsCardNumber = entityDetailsPanel.getDetailsCardNumber();
        
        this.detailsCardType.setModel(cardTypeComboBoxModel);
        
        this.setEditable(false);
    }
    
    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        detailsName.setEnabled(editable);
        detailsCardType.setEnabled(editable);
        detailsCardNumber.setEnabled(editable);
        
    }

    public Customer getEntity() {
        return entity;
    }

    public void setEntity(Customer entity) {
        this.entity = entity;
    }
    
    public void loadData() {       
        if (entity == null) {
            entity = new Customer("", 0L, "");
        }
        detailsName.setText(entity.getName());
        detailsCardNumber.setText(entity.getCardNumber());
        CardType cardTypeItem;
        for (int i = 0; i < detailsCardType.getItemCount(); i++) {
            cardTypeItem = detailsCardType.getItemAt(i);
            if (Objects.equals(cardTypeItem.getId(), entity.getIdCardType())){
                detailsCardType.setSelectedIndex(i);
                break;
            }
        }
        
        detailsName.requestFocus();
    }
    
    public void saveData() {
        if (entity == null) {
            entity = new Customer("", 0L, "");
        }
        CardType cardType = (CardType) cardTypeComboBoxModel.getSelectedItem();
        entity.setName(detailsName.getText());
        entity.setIdCardType(cardType.getId());
        entity.setCardNumber(detailsCardNumber.getText());
    }

    public CustomerCardTypeComboBoxModel getCardTypeComboBoxModel() {
        return cardTypeComboBoxModel;
    }

    public void setCardTypeComboBoxModel(CustomerCardTypeComboBoxModel cardTypeComboBoxModel) {
        this.cardTypeComboBoxModel = cardTypeComboBoxModel;
        detailsCardType.setModel(cardTypeComboBoxModel);
    }    
}
