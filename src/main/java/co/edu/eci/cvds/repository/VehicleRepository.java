package co.edu.eci.cvds.repository;
import co.edu.eci.cvds.model.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    public List<Vehicle> findByVehicleId(String vehicleId);
    public List<Vehicle> findByModel(String model);
   // Vehicle findByModelAndYear(String model, int year);
   // Vehicle findByModelAndYearAndCylinder(String model, int year,Integer cylinder);
}