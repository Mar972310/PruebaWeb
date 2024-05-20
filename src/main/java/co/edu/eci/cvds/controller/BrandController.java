package co.edu.eci.cvds.controller;
import co.edu.eci.cvds.model.Brand;
import co.edu.eci.cvds.model.Vehicle;
import co.edu.eci.cvds.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;
@Controller
@RequestMapping("/api/brand")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;   
    }

    @GetMapping("/{brandId}")
    public String tolListVehicles(@PathVariable String brandId, Model model){
        Brand brand = brandService.getbrand(brandId);
        List<Vehicle> vehicles = brand.getVehicles();
        model.addAttribute("vehicles", vehicles);
        return "fragments/selectVehicle :: model";
    }

    public List<Brand> toList(){
        return brandService.getAllBrands();
    }
}

