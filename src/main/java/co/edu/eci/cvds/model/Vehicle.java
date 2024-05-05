package co.edu.eci.cvds.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;

@Entity
@Table(name = "VEHICLES")
@JsonDeserialize
public class Vehicle implements Serializable {

    @Id

    @Column(name = "ID")
    private String vehicleId;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "VEHICLE_YEAR")
    private int year;

    @Column(name = "CYLINDER_CAPACITY")
    private int cylinderCapacity;

    @OneToMany(mappedBy = "vehicle") // Relación One-to-Many con la entidad Quote
    private List<Quote> quotes;

    public Vehicle() {
    }

    public Vehicle(String brand, String model, int year, int cylinderCapacity) {
        this.vehicleId = UUID.randomUUID().toString();
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.cylinderCapacity = cylinderCapacity;
    }

    // Getters y setters

    public String getId() {
        return vehicleId;
    }

    public void setId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(int cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }
}
