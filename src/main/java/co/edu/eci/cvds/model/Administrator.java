package co.edu.eci.cvds.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;

@Entity
@Table(name = "ADMINISTRATORS")
@JsonDeserialize
public class Administrator implements Serializable {

    @Id
    @Column(name = "email", nullable=false, unique=true)
    private String email;

    @Column(name="PASSWORD")
    private String password;

    public Administrator() {
    }

    public Administrator(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters y setters

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
