package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Vehicle;
import co.edu.eci.cvds.model.Configuration;
import co.edu.eci.cvds.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService( VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle addProduct(Vehicle vehicle) {
        vehicle.setVehicleId(UUID.randomUUID().toString());
        return vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle> getVehicleM(String vehicleId) {
        return vehicleRepository.findById(vehicleId);
    }
    public Vehicle getVehicle(String vehicleId) {
        return vehicleRepository.findById(vehicleId).get();
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(String vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }

}