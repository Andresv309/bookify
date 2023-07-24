
package app.controllers.shoppingCart;

import java.util.Objects;


public class ShoppingCartUserInfoModel {
    private Long idCardType;
    private String cardNumber;
    private String cardType;

    public ShoppingCartUserInfoModel(Long idCardType, String cardNumber, String cardType) {
        this.idCardType = idCardType;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }

    public Long getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(Long idCardType) {
        this.idCardType = idCardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.idCardType);
        hash = 67 * hash + Objects.hashCode(this.cardNumber);
        hash = 67 * hash + Objects.hashCode(this.cardType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ShoppingCartUserInfoModel other = (ShoppingCartUserInfoModel) obj;
        if (!Objects.equals(this.cardNumber, other.cardNumber)) {
            return false;
        }
        if (!Objects.equals(this.cardType, other.cardType)) {
            return false;
        }
        return Objects.equals(this.idCardType, other.idCardType);
    }

    @Override
    public String toString() {
        return "ShoppingCartUserInfo{" + "idCardType=" + idCardType + ", cardNumber=" + cardNumber + ", cardType=" + cardType + '}';
    }
}
