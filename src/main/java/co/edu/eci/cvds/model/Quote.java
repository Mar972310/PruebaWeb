package co.edu.eci.cvds.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;

@Entity
@Table(name = "QUOTES")
@JsonDeserialize
public class Quote implements Serializable {

    @Id
    @Column(name = "ID")
    private String quoteId;

    @Column(name = "ESTATE")
    private String estate;

    @Column(name = "PRICE")
    private double price;

    @ManyToOne // Relación Many-to-One con la entidad Vehicle
    @JoinColumn(name = "VEHICLE_ID", referencedColumnName = "ID", nullable = true) // Columna de la llave foránea
    private Vehicle vehicle;

    @OneToMany(mappedBy = "quote") // Relación One-to-Many con la entidad Product
    private List<Product> products;

    public Quote() {
    }

    public Quote(String estate, double price, Vehicle vehicle) {
        this.estate = estate;
        this.price = price;
        this.vehicle = vehicle;
    }

    // Getters y setters

    public String getId() {
        return quoteId;
    }

    public void setId(String quoteId) {
        this.quoteId = quoteId;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
