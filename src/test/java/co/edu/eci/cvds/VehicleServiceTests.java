package co.edu.eci.cvds;

import co.edu.eci.cvds.model.Vehicle;
import co.edu.eci.cvds.repository.VehicleRepository;
import co.edu.eci.cvds.service.VehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

class VehicleServiceTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleService vehicleService;

    private Vehicle vehicle;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        vehicle = new Vehicle();
        vehicle.setVehicleId(UUID.randomUUID().toString());
        vehicle.setModel("TestModel");
        vehicle.setYear(2024);
        vehicle.setCylinderCapacity(2000);
    }

    @Test
    void addVehicle() {
        when(vehicleRepository.save(vehicle)).thenReturn(vehicle);
        Vehicle result = vehicleService.addProduct(vehicle);
        assertEquals(vehicle.getVehicleId(), result.getVehicleId());
    }

    @Test
    void getVehicle() {
        when(vehicleRepository.findById(anyString())).thenReturn(Optional.of(vehicle));
        Vehicle result = vehicleService.getVehicle("1");
        assertEquals(vehicle.getModel(), result.getModel());
    }

    @Test
    void getAllVehicles() {
        List<Vehicle> vehicles = List.of(vehicle);
        when(vehicleRepository.findAll()).thenReturn(vehicles);
        List<Vehicle> result = vehicleService.getAllVehicles();
        assertEquals(vehicles.size(), result.size());
        assertEquals(vehicle.getModel(), result.get(0).getModel());
    }

    @Test
    void updateVehicle() {
        when(vehicleRepository.save(vehicle)).thenReturn(vehicle);
        Vehicle result = vehicleService.updateVehicle(vehicle);
        assertEquals(vehicle.getModel(), result.getModel());
    }

    @Test
    void deleteVehicle() {
        vehicleService.deleteVehicle(vehicle.getVehicleId());
        verify(vehicleRepository).deleteById(vehicle.getVehicleId());
    }

    @Test
    void getVehiclesModel() {
        List<Vehicle> vehicles = List.of(vehicle);
        String model = "TestModel";
        when(vehicleRepository.findByModel(model)).thenReturn(vehicles);
        List<Vehicle> result = vehicleService.getVehiclesModel(model);
        assertEquals(vehicles.size(), result.size());
        assertEquals(vehicle.getModel(), result.get(0).getModel());
    }

    @Test
    void getYearsCylinders() {
        List<Vehicle> vehicles = List.of(vehicle);
        String model = "TestModel";
        when(vehicleRepository.findByModel(model)).thenReturn(vehicles);
    }
    @Test
    void getYearsCylinders1() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);
        String model = "TestModel";
        when(vehicleRepository.findByModel(model)).thenReturn(vehicles);

        Map<String, List<Integer>> expected = new HashMap<>();
        List<Integer> years = List.of(2024);
        List<Integer> cylinders = List.of(2000);
        expected.put("years", years);
        expected.put("cylinders", cylinders);

        Map<String, List<Integer>> result = vehicleService.getYearsCylinders(model);

        assertEquals(expected.get("years"), result.get("years"));
        assertEquals(expected.get("cylinders"), result.get("cylinders"));
    }
}
