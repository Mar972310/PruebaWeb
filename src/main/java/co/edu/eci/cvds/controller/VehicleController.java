package co.edu.eci.cvds.controller;

import co.edu.eci.cvds.model.Vehicle;
import co.edu.eci.cvds.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;   
    }

    public List<Vehicle> toList(){
        return vehicleService.getAllVehicles();
    }




    

/**
    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle Vehicle) {
        Vehicle newVehicle = VehicleService.addVehicle(Vehicle);
        return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
    }

    @GetMapping("/{VehicleId}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable String VehicleId) {
        Vehicle Vehicle = VehicleService.getVehicle(VehicleId);
        return new ResponseEntity<>(Vehicle, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> Vehicles = VehicleService.getAllVehicles();
        return new ResponseEntity<>(Vehicles, HttpStatus.OK);
    }

    @PutMapping("/{VehicleId}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable String VehicleId, @RequestBody Vehicle VehicleDetails) {
        VehicleDetails.setVehicleId(VehicleId);
        Vehicle updatedVehicle = VehicleService.updateVehicle(VehicleDetails);
        return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
    }

    @DeleteMapping("/{VehicleId}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable String VehicleId) {
        VehicleService.deleteVehicle(VehicleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Otros métodos según sea necesario
     */

}
