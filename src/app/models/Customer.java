
package app.models;

import java.util.Objects;


public class Customer {
    private Long id = null;
    private String name;
    private Long idCardType;
    private String cardNumber;

    public Customer(String name, Long idCardType, String cardNumber) {
        this.name = name;
        this.idCardType = idCardType;
        this.cardNumber = cardNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.idCardType);
        hash = 41 * hash + Objects.hashCode(this.cardNumber);
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
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.cardNumber, other.cardNumber)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.idCardType, other.idCardType);
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", idCardType=" + idCardType + ", cardNumber=" + cardNumber + '}';
    }
}
