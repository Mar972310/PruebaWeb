package co.edu.eci.cvds.model;

import java.io.Serializable;
import co.edu.eci.cvds.model.Category;
import java.util.UUID;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCTS")
@JsonDeserialize
public class Product implements Serializable {

    @Id
    @Column(name = "ID")
    private String productId;
    @Column(name = "NAME")
    private String name; 
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "TECHNICAL_DESCRIPTION")
    private String technicalDescription;
    @Column(name = "IMAGE")
    private String image;
    @Column(name = "PRICE")
    private double price;
    @Column(name = "COIN")
    private String coin;
    @Column(name = "DISCOUNT")
    private int discount;
    @Column(name = "TAX")
    private int tax;
    @ManyToOne // Relación Many-to-One con la entidad Category
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID", nullable = true) // Columna de la llave foránea
    private Category category;

    @ManyToOne // Relación Many-to-One con la entidad Supplier
    @JoinColumn(name = "QUOTE_ID", referencedColumnName = "ID", nullable = true) // Columna de la llave foránea
    private Quote quote;

    public Product() {
    }

    public Product(String name, String description, String technicalDescription, String image, int price, String coin, int discount, int tax, Category category, Quote quote) {
        this.productId = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.technicalDescription = technicalDescription;
        this.image = image;
        this.price = price;
        this.coin = coin;
        this.discount = discount;
        this.tax = tax;
        this.category = category;
        this.quote = quote;
    }

    // Getters y setters

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnicalDescription() {
        return technicalDescription;
    }

    public void setTechnicalDescription(String technicalDescription) {
        this.technicalDescription = technicalDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }
}