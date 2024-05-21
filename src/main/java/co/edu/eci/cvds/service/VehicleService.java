package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Vehicle;
import co.edu.eci.cvds.model.Configuration;
import co.edu.eci.cvds.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public List<Vehicle> getVehiclesModel(String model){
        return vehicleRepository.findByModel(model);
    }

    public Map<String, List<Integer>> getYearsCylinders(String model){
        List<Vehicle> vehicles = getVehiclesModel(model);
        List<Integer> years = new ArrayList<>();
        List<Integer> cylinders = new ArrayList<>();

        for(Vehicle v:vehicles){
            years.add(v.getYear());
            if (!v.getCylinderCapacity().equals(null)){
                cylinders.add(v.getCylinderCapacity());
            }
        }
        Map<String, List<Integer>> data = new HashMap<>();
        data.put("years", years);
        data.put("cylinders", cylinders);
        return data;
    }
    /**public Vehicle findVehicle(String model, int year, int cylinder) {
        if(cylinder != 1 && cylinder != 0){
            return vehicleRepository.findByModelAndYearAndCylinder(model, year,cylinder);
        }
        else{
            return vehicleRepository.findByModelAndYear(model, year);
        }
        
    }*/

}