package co.edu.eci.cvds;

import co.edu.eci.cvds.model.Product;
import co.edu.eci.cvds.repository.ProductRepository;
import co.edu.eci.cvds.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product("Laptop", "High-performance laptop", "Technical specifications here",
                "laptop_image.jpg", 1000, "USD", 0, 0, null, null);
        product.setProductId("1");
    }

    @Test
    void addProduct() {
        when(productRepository.save(any(Product.class))).thenReturn(product);
        Product result = productService.addProduct(product);
        assertNotNull(result);
        assertEquals("Laptop", result.getName());
    }

    @Test
    void getProductM() {
        when(productRepository.findById(anyString())).thenReturn(Optional.of(product));
        Optional<Product> result = productService.getProductM("1");
        assertTrue(result.isPresent());
        assertEquals("Laptop", result.get().getName());
    }

    @Test
    void getProduct() {
        when(productRepository.findById(anyString())).thenReturn(Optional.of(product));
        Product result = productService.getProduct("1");
        assertNotNull(result);
        assertEquals("Laptop", result.getName());
    }

    @Test
    void getAllProducts() {
        List<Product> productList = Arrays.asList(product, new Product("Tablet", "High-performance tablet", "Technical specifications here",
                "tablet_image.jpg", 500, "USD", 0, 0, null, null));
        when(productRepository.findAll()).thenReturn(productList);
        List<Product> result = productService.getAllProducts();
        assertEquals(2, result.size());
    }

    @Test
    void updateProduct() {
        when(productRepository.save(any(Product.class))).thenReturn(product);
        Product result = productService.updateProduct(product);
        assertNotNull(result);
        assertEquals("Laptop", result.getName());
    }

    @Test
    void deleteProduct() {
        doNothing().when(productRepository).deleteById(anyString());
        assertDoesNotThrow(() -> productService.deleteProduct("1"));
        verify(productRepository, times(1)).deleteById("1");
    }

    @Test
    void getName() {
        when(productRepository.findByProductId(anyString())).thenReturn(Arrays.asList(product));
        String result = productService.getName();
        assertEquals("Laptop", result);
    }
}
