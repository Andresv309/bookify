
package app.models;

import java.util.Objects;


public class Stock {
    private Long id = null;
    private Long idBook;
    private Long quantity;

    public Stock(Long idBook, Long quantity) {
        this.idBook = idBook;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.idBook);
        hash = 97 * hash + Objects.hashCode(this.quantity);
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
        final Stock other = (Stock) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idBook, other.idBook)) {
            return false;
        }
        return Objects.equals(this.quantity, other.quantity);
    }

    @Override
    public String toString() {
        return "Stock{" + "id=" + id + ", idBook=" + idBook + ", quantity=" + quantity + '}';
    }   
}
