
package app.models;

import java.util.Objects;


public class SaleItems {
    private Long id = null;
    private Long idSale;
    private Long idBook;

    public SaleItems(Long idSale, Long idBook) {
        this.idSale = idSale;
        this.idBook = idBook;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdSale() {
        return idSale;
    }

    public void setIdSale(Long idSale) {
        this.idSale = idSale;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.idSale);
        hash = 53 * hash + Objects.hashCode(this.idBook);
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
        final SaleItems other = (SaleItems) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idSale, other.idSale)) {
            return false;
        }
        return Objects.equals(this.idBook, other.idBook);
    }

    @Override
    public String toString() {
        return "SaleItems{" + "id=" + id + ", idSale=" + idSale + ", idBook=" + idBook + '}';
    }
}
