
package app.models;

import java.util.Objects;


public class Shelv {
    private Long id = null;
    private String name;

    public Shelv(String category) {
        this.name = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return name;
    }

    public void setCategory(String category) {
        this.name = category;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.name);
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
        final Shelv other = (Shelv) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
   

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", category=" + name + '}';
    } 
}