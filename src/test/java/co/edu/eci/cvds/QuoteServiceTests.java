package co.edu.eci.cvds;

import co.edu.eci.cvds.model.Quote;
import co.edu.eci.cvds.model.Brand;
import co.edu.eci.cvds.model.Product;
import co.edu.eci.cvds.model.Vehicle;
import co.edu.eci.cvds.repository.QuoteRepository;
import co.edu.eci.cvds.service.QuoteService;

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

class QuoteServiceTest {

    @Mock
    private QuoteRepository quoteRepository;

    @InjectMocks
    private QuoteService quoteService;

    private Quote quote;
    private Vehicle vehicle;
    private Product product;
    private Brand brand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        quote = new Quote("Creado", 0, null);
        quote.setId("1");

        brand = new Brand("Toyota");

        vehicle = new Vehicle(brand, "Corolla", 2020, 500);
        vehicle.setVehicleId("1");

        product = new Product("Laptop", "High-performance laptop", "Technical specifications here",
                "laptop_image.jpg", 1000, "USD", 0, 0, null, null);
        product.setProductId("1");
    }

    @Test
    void addProducts() {
        when(quoteRepository.save(any(Quote.class))).thenReturn(quote);
        Quote result = quoteService.addProducts(quote, product);
        assertNotNull(result);
        assertEquals("En proceso", result.getEstate());
        assertEquals(1000, result.getPrice());
    }
    @Test
    void addQuote() {
        when(quoteRepository.save(any(Quote.class))).thenReturn(quote);
        Quote result = quoteService.addQuote(quote, vehicle);
        assertNotNull(result);
        assertEquals("Creado", result.getEstate());
    }

    @Test
    void getQuote() {
        when(quoteRepository.findById(anyString())).thenReturn(Optional.of(quote));
        Quote result = quoteService.getQuote("1");
        assertNotNull(result);
        assertEquals("Creado", result.getEstate());
    }

    @Test
    void getAllQuotes() {
        List<Quote> quoteList = Arrays.asList(quote, new Quote("En proceso", 1500, vehicle));
        when(quoteRepository.findAll()).thenReturn(quoteList);
        List<Quote> result = quoteService.getAllQuotes();
        assertEquals(2, result.size());
    }

    @Test
    void updateQuote() {
        when(quoteRepository.save(any(Quote.class))).thenReturn(quote);
        Quote result = quoteService.updateQuote(quote);
        assertNotNull(result);
        assertEquals("Creado", result.getEstate());
    }

    @Test
    void deleteQuote() {
        doNothing().when(quoteRepository).deleteById(anyString());
        assertDoesNotThrow(() -> quoteService.deleteQuote("1"));
        verify(quoteRepository, times(1)).deleteById("1");
    }
}
