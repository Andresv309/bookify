
package app.models;

import java.util.Objects;


public class Stock {
    private Long id = null;
    private Long quantity;
    private Long idShelve;
    private Long idBook;
    private String bookName;
    private String shelveName;

    public Stock(Long quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getIdShelve() {
        return idShelve;
    }

    public void setIdShelve(Long idShelve) {
        this.idShelve = idShelve;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getShelveName() {
        return shelveName;
    }

    public void setShelveName(String shelveName) {
        this.shelveName = shelveName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.quantity);
        hash = 53 * hash + Objects.hashCode(this.idShelve);
        hash = 53 * hash + Objects.hashCode(this.idBook);
        hash = 53 * hash + Objects.hashCode(this.bookName);
        hash = 53 * hash + Objects.hashCode(this.shelveName);
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
        if (!Objects.equals(this.bookName, other.bookName)) {
            return false;
        }
        if (!Objects.equals(this.shelveName, other.shelveName)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.quantity, other.quantity)) {
            return false;
        }
        if (!Objects.equals(this.idShelve, other.idShelve)) {
            return false;
        }
        return Objects.equals(this.idBook, other.idBook);
    }

    @Override
    public String toString() {
        return "Stock{" + "id=" + id + ", quantity=" + quantity + ", idShelve=" + idShelve + ", idBook=" + idBook + ", bookName=" + bookName + ", shelveName=" + shelveName + '}';
    }
}
