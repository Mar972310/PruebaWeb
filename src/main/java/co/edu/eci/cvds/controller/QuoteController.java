package co.edu.eci.cvds.controller;


import co.edu.eci.cvds.model.Configuration;
import co.edu.eci.cvds.model.Quote;
import co.edu.eci.cvds.model.Product;
import co.edu.eci.cvds.model.Category;
import co.edu.eci.cvds.service.CategoryService;
import co.edu.eci.cvds.service.ProductService;
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
    

    
    public QuoteController(QuoteService quoteService,ProductService productService,CategoryService categoryService){
        this.quoteService = quoteService;
        this.productService = productService;
        this.categoryService = categoryService;
    }
    
    @GetMapping("/admistrator/listQuote")
    public String toList(Model model){
        List<Quote> quotes = quoteService.getAllQuotes();
        model.addAttribute("quotes", quotes);
        return "listQuotes";
    }

    @GetMapping("")
    public String informationClient(Model model){
        List<Product> products = productService.getAllProducts();
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("products",products);
        model.addAttribute("categories",categories);
        return "listProductsClient";
    }
    
    @GetMapping("/{categoryId}")
    public String productsQuote(@PathVariable String categoryId, Model model){
        if (!categoryId.equals("0")){
            Category category = categoryService.getCategory(categoryId);
        if (!category.equals(null)) {
            List<Product>products = category.getProducts();
            List<Category> categories = categoryService.getAllCategories();
            model.addAttribute("products",products);
            model.addAttribute("categories",categories);
            return "listProductsClient";
        } else {
            // Manejo de error si no se encuentra el empleado
            return "error"; // Puedes redirigir a una página de error
        }
        }else{
            return "redirect:/api/quote";
        }
    }  
    
}
