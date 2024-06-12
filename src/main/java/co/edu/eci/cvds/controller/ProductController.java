package co.edu.eci.cvds.controller;

import co.edu.eci.cvds.model.Product;
import co.edu.eci.cvds.service.ProductService;
import co.edu.eci.cvds.service.CategoryService;
import co.edu.eci.cvds.service.UploadImageService;

import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final UploadImageService uploadImageService;


    @Autowired
    public ProductController(ProductService productService, UploadImageService uploadImageService) {
        this.productService = productService;
        this.uploadImageService = uploadImageService;
    }

    @GetMapping("")
    public String toList(Model model) {
        List<Product> products=productService.getAllProducts();
        model.addAttribute("products", products);

        return "listProducts";
    }

    @GetMapping("/client")
    public String to(Model model) {
        List<Product> products=productService.getAllProducts();
        model.addAttribute("products", products);
        return "listProductsClient";
    }

    @GetMapping("/update/{productId}")
    public String updateProduct(@PathVariable String productId, Model model) {
        Product product = productService.getProduct(productId);
        if (product != null) {
            model.addAttribute("product", product);
            return "updateProducts";
        } else {
            // Manejo de error si no se encuentra el empleado
            return "error"; // Puedes redirigir a una página de error
        }
    }

    @PostMapping("/update/{productId}")
    public String update(@PathVariable String productId, @ModelAttribute("product") Product productUpdate) {
        Optional<Product> optionalProduct = productService.getProductM(productId);
        Product product = optionalProduct.get();
        if (!product.equals(null)) {
            product.setName(productUpdate.getName());
            product.setDescription(productUpdate.getDescription());
            product.setTechnicalDescription(productUpdate.getTechnicalDescription());
            product.setCoin(productUpdate.getCoin());
            product.setTechnicalDescription(productUpdate.getTechnicalDescription());
            product.setPrice(productUpdate.getPrice());
            product.setDiscount(productUpdate.getDiscount());
            product.setTax(productUpdate.getTax());
            productService.updateProduct(product);
            return "redirect:/api/products";
        } else {
            return "error";
        }
    }



    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable String productId, Model model) {
        productService.deleteProduct(productId);
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "fragments/productsAdmin :: grid-container"; // Devuelve solo el fragmento de la lista de productos
    }



    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "createProducts";
    }


	@GetMapping(value = "/uploads/{filename}")
	public ResponseEntity<Resource> goImage(@PathVariable String filename) {
		Resource resource = null;
		try {
			resource = uploadImageService.load(filename);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
   
    @PostMapping("/save")
	public String saveproduct(@Validated @ModelAttribute("product") Product product, BindingResult result, Model model,
			@RequestParam("file") MultipartFile image, RedirectAttributes flash, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			System.out.println(result.getFieldError());
			return "createProduct";
		} else {
			if (!image.isEmpty()) {
				String uniqueFileName = uploadImageService.copy(image);
				product.setImage(uniqueFileName);
			}
			productService.addProduct(product);
			status.setComplete();
		}
		return "redirect:/api/products";
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
