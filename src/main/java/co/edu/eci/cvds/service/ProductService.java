package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Product;
import co.edu.eci.cvds.model.Configuration;
import co.edu.eci.cvds.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(String productId) {
        return productRepository.findById(productId).get();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }

    public String getName() {
        return productRepository.findByProductId("1").get(0).getName();
    }
}