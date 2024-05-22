package co.edu.eci.cvds.controller;

import co.edu.eci.cvds.model.Brand;
import co.edu.eci.cvds.model.Product;
import co.edu.eci.cvds.model.Vehicle;
import co.edu.eci.cvds.service.VehicleService;
import co.edu.eci.cvds.service.BrandService;
import co.edu.eci.cvds.service.CategoryService;
import co.edu.eci.cvds.service.UploadImageService;

import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/api/user")
public class UserController {

    private final BrandService brandService;
    private final VehicleService vehicleService;

    @Autowired
    public UserController (BrandService brandService,VehicleService vehicleService) {
        this.brandService = brandService;
        this.vehicleService=vehicleService;
    }
   /**  @GetMapping("")
    public String toList(Model model) {
        return "Login";
    }*/

    @GetMapping("")
    public String toList(Model model) {
        List<Brand> brands = brandService.getAllBrands();
        model.addAttribute("brands", brands);
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        model.addAttribute("vehicles", vehicles);
        return "pruebaLogin";
    }

    @GetMapping("/model/{brandId}")
    public String tolListVehicles(@PathVariable String brandId, Model model){
        Brand brand = brandService.getbrand(brandId);
        List<Vehicle> vehicles = brand.getVehicles();
        model.addAttribute("vehicles", vehicles);
        return "fragments/selectVehicle :: model";
    }


/**
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable String productId) {
        Product product = productService.getProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable String productId, @RequestBody Product productDetails) {
        productDetails.setProductId(productId);
        Product updatedProduct = productService.updateProduct(productDetails);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Otros métodos según sea necesario
     */

}
