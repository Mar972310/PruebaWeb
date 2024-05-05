package co.edu.eci.cvds.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORIES")
@JsonDeserialize
public class Category implements Serializable {

    @Id
    @Column(name = "ID")
    private String categoryId;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "category") // Relación One-to-Many con la entidad Product
    private List<Product> products;

    public Category() {
    }

    public Category(String name) {
        this.categoryId = UUID.randomUUID().toString();
        this.name = name;
    }

    // Getters y setters

    public String getId() {
        return categoryId;
    }

    public void setId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
