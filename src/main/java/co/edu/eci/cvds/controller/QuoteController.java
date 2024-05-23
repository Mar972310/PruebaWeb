package co.edu.eci.cvds.controller;


import co.edu.eci.cvds.model.Quote;
import co.edu.eci.cvds.model.Vehicle;
import co.edu.eci.cvds.model.Product;
import co.edu.eci.cvds.model.Brand;
import co.edu.eci.cvds.model.Category;
import co.edu.eci.cvds.service.CategoryService;
import co.edu.eci.cvds.service.ProductService;
import co.edu.eci.cvds.service.VehicleService;
import co.edu.eci.cvds.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/api/quote")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final VehicleService vehicleService;

    
    public QuoteController(QuoteService quoteService,ProductService productService,CategoryService categoryService, VehicleService vehicleService){
        this.quoteService = quoteService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.vehicleService =vehicleService;
    }
    
    @GetMapping("/admistrator/listQuote")
    public String toList(Model model){
        List<Quote> quotes = quoteService.getAllQuotes();
        model.addAttribute("quotes", quotes);
        return "listQuotes";
    }



    @GetMapping("")
    public String informationClient(Model model, @RequestParam("vehicleId") String vehicleId) {
        Quote quote= new Quote();
        Vehicle vehicleSelect = vehicleService.getVehicle(vehicleId);
        quoteService.addQuote(quote,vehicleSelect);
        List<Product> productsSelect = new ArrayList<>();
        List<Product> products = productService.getAllProducts();
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("products",products);
        model.addAttribute("productsSelect",productsSelect);
        model.addAttribute("categories",categories);
        model.addAttribute("quote",quote);
        return "listProductsClient";
    }


    
    @GetMapping("/{categoryId}")
    public String productsQuote(@PathVariable String categoryId, Model model){
        if (!categoryId.equals("0")){
            Category category = categoryService.getCategory(categoryId);
            if (!category.equals(null)) {
                List<Product>products = category.getProducts();
                model.addAttribute("products",products);
                return "fragments/productClient :: grid-container";
            } else {
                // Manejo de error si no se encuentra el empleado
                return "error"; // Puedes redirigir a una página de error
            }
        }else{
            List<Product> products = productService.getAllProducts();
            model.addAttribute("products",products);
            return "fragments/productClient :: grid-container";
        }
    }  

    @DeleteMapping("/delete/{quoteId}/{productId}")
    public String deleteQuote(@PathVariable String quoteId, @PathVariable String productId, Model model) {
        Product product = productService.getProduct(productId);
        Quote quote = quoteService.getQuote(quoteId);
        quoteService.deleteProducts(quote, product);
        List<Product> products = quote.getProducts();
        model.addAttribute("productsSelect", products);
        model.addAttribute("quote",quote);
        return "fragments/shopCar :: grid-container";
    }
    
    @PostMapping("/update/{quoteId}/{productId}")
    public String updateQuote(@PathVariable String quoteId, @PathVariable String productId, Model model) {
        Product product = productService.getProduct(productId);
        Quote quote = quoteService.getQuote(quoteId);
        quoteService.addProducts(quote, product);
        List<Product> products = quote.getProducts();
        int count = 0;
        for (Product p : products) {
            System.out.println(count+1);
            System.out.println("Producto: " + p.getName() + ", Precio: " + p.getPrice());
        }
        model.addAttribute("productsSelect", products);
        model.addAttribute("quote",quote);
        return "fragments/shopCar :: grid-container";
    }

    @GetMapping("/view/{quoteId}")
    public String viewQuote(@PathVariable String quoteId,Model model) {
        Quote quote = quoteService.getQuote(quoteId);
        List<Product> products = quote.getProducts();
        model.addAttribute("productsSelect", products);
        model.addAttribute("quote",quote);
        return "fragments/shopCar :: grid-container";
    }

    @PostMapping("/update/{quoteId}")
public String stateUpdate(@PathVariable String quoteId, @RequestParam("estate") String estate, Model model) {
    quoteService.endQuote(quoteId, estate);
    model.addAttribute("message", "Estado de la cotización actualizado exitosamente");
    return "redirect:/api/quote/admistrator/listQuote";
}


    @GetMapping("/view_edit/{quoteId}")
    public String viewPQuote(@PathVariable String quoteId, Model model){
        Quote quote = quoteService.getQuote(quoteId);
        List<Product> products = quote.getProducts();
        Vehicle vehicle = quote.getVehicle();
        model.addAttribute("productsSelect", products);
        model.addAttribute("quote",quote);
        model.addAttribute("vehicle",vehicle);
        return "detailsQuotes";
    }

    @GetMapping("/update/{quoteId}")
    public String updateQuote(@PathVariable String quoteId,Model model) {
        Quote quote = quoteService.getQuote(quoteId);
        List<Product> products = quote.getProducts();
        Vehicle vehicle = quote.getVehicle();
        model.addAttribute("productsSelect", products);
        model.addAttribute("quote",quote);
        model.addAttribute("vehicle",vehicle);
        return "updatesQuotes";
    }



}
