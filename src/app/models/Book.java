
package app.models;

import java.math.BigDecimal;
import java.util.Objects;


public class Book {
    private Long id = null;
    private String name;
    private Long idCategory;
    private String description;
    private BigDecimal price;
    private Long idAuthor;
    private String imgPath;
    private String categoryName;
    private String authorName;

    public Book(String name, String description, BigDecimal price, Long idCategory, Long idAuthor, String imgPath) {
        this.name = name;
        this.idCategory = idCategory;
        this.description = description;
        this.price = price;
        this.idAuthor = idAuthor;
        this.imgPath = imgPath;
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

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.name);
        hash = 61 * hash + Objects.hashCode(this.idCategory);
        hash = 61 * hash + Objects.hashCode(this.description);
        hash = 61 * hash + Objects.hashCode(this.price);
        hash = 61 * hash + Objects.hashCode(this.idAuthor);
        hash = 61 * hash + Objects.hashCode(this.imgPath);
        hash = 61 * hash + Objects.hashCode(this.categoryName);
        hash = 61 * hash + Objects.hashCode(this.authorName);
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
        final Book other = (Book) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.imgPath, other.imgPath)) {
            return false;
        }
        if (!Objects.equals(this.categoryName, other.categoryName)) {
            return false;
        }
        if (!Objects.equals(this.authorName, other.authorName)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idCategory, other.idCategory)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return Objects.equals(this.idAuthor, other.idAuthor);
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name=" + name + ", idCategory=" + idCategory + ", description=" + description + ", price=" + price + ", idAuthor=" + idAuthor + ", imgPath=" + imgPath + ", categoryName=" + categoryName + ", authorName=" + authorName + '}';
    }
}
