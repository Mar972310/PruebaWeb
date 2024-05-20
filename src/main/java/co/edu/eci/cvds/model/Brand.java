package co.edu.eci.cvds.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;

@Entity
@Table(name = "BRANDS")
@JsonDeserialize
public class Brand {

    @Id
    @Column(name = "ID")
    private String brandId;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "brand") // Relación One-to-Many con la entidad Product
    private List<Vehicle> vehicles;

    public Brand(){
        
    }

    public Brand(String name) {
        this.brandId = UUID.randomUUID().toString();
        this.name = name;
    }

    // Getters y setters

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String categoryId) {
        this.brandId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
