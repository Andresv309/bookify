
package app.models;

import java.math.BigDecimal;
import java.util.Objects;


public class Sale {
   private Long id = null;
   private Long idBook;
   private Long idCustomer = null;
   private BigDecimal salePrice;
   private Long idSaleParent = null;
   private String createdAt;
   private String customerName;
   private String bookName;
   

    public Sale(Long idBook, BigDecimal salePrice) {
        this.idBook = idBook;
        this.salePrice = salePrice;
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

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Long getIdSaleParent() {
        return idSaleParent;
    }

    public void setIdSaleParent(Long idSaleParent) {
        this.idSaleParent = idSaleParent;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.idBook);
        hash = 31 * hash + Objects.hashCode(this.idCustomer);
        hash = 31 * hash + Objects.hashCode(this.salePrice);
        hash = 31 * hash + Objects.hashCode(this.idSaleParent);
        hash = 31 * hash + Objects.hashCode(this.createdAt);
        hash = 31 * hash + Objects.hashCode(this.customerName);
        hash = 31 * hash + Objects.hashCode(this.bookName);
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
        if (!Objects.equals(this.createdAt, other.createdAt)) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.bookName, other.bookName)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idBook, other.idBook)) {
            return false;
        }
        if (!Objects.equals(this.idCustomer, other.idCustomer)) {
            return false;
        }
        if (!Objects.equals(this.salePrice, other.salePrice)) {
            return false;
        }
        return Objects.equals(this.idSaleParent, other.idSaleParent);
    }

    @Override
    public String toString() {
        return "Sale{" + "id=" + id + ", idBook=" + idBook + ", idCustomer=" + idCustomer + ", salePrice=" + salePrice + ", idSaleParent=" + idSaleParent + ", createdAt=" + createdAt + ", customerName=" + customerName + ", bookName=" + bookName + '}';
    }
}
