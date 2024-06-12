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

    @Column(name = "IMAGE")
    private String image;

    @ManyToOne // Relación Many-to-One con la entidad Brand
    @JoinColumn(name = "BRAND_ID", referencedColumnName = "ID", nullable = true)
    private Brand brand;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "VEHICLE_YEAR")
    private int year;

    @Column(name = "CYLINDER_CAPACITY",nullable = true)
    private Integer cylinderCapacity;


    public Vehicle() {
    }

    public Vehicle(Brand brand,String model, int year, int cylinderCapacity) {
        this.vehicleId = UUID.randomUUID().toString();
        this.brand =brand;
        this.model = model;
        this.year = year;
        this.cylinderCapacity = cylinderCapacity;
    }

    // Getters y setters

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Integer getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(int cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

}
