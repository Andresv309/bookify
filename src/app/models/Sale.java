
package app.models;

import java.util.List;
import java.util.Objects;


public class Sale {
   private Long id = null;
   private Long idCustomer;
   private List<Long> idBooks;

    public Sale(Long idCustomer, List<Long> idBooks) {
        this.idCustomer = idCustomer;
        this.idBooks = idBooks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public List<Long> getIdBooks() {
        return idBooks;
    }

    public void setIdBooks(List<Long> idBooks) {
        this.idBooks = idBooks;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.idCustomer);
        hash = 71 * hash + Objects.hashCode(this.idBooks);
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
        final Sale other = (Sale) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idCustomer, other.idCustomer)) {
            return false;
        }
        return Objects.equals(this.idBooks, other.idBooks);
    }

    @Override
    public String toString() {
        return "Sale{" + "id=" + id + ", idCustomer=" + idCustomer + ", idBooks=" + idBooks + '}';
    }
}
