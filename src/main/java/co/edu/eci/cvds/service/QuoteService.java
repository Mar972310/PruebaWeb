package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Quote;
import co.edu.eci.cvds.model.Product;
import co.edu.eci.cvds.model.Vehicle;
import co.edu.eci.cvds.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class QuoteService {
    private final QuoteRepository quoteRepository; 

    @Autowired
    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public Quote addQuote(Quote quote,Vehicle vehicle) {
        quote.setId(UUID.randomUUID().toString());
        quote.setEstate("Activo");
        quote.setVehicle(vehicle);
        quote.setPrice(0);
        quote.setProducts(null);
        return quoteRepository.save(quote);
    }

    public Quote getQuote(String quoteId) {
        return quoteRepository.findById(quoteId).get();
    }

    public List<Quote> getAllQuotes() {
        return (List<Quote>)quoteRepository.findAll();
    }

    public Quote updateQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    public void deleteQuote(String quoteId) {
        quoteRepository.deleteById(quoteId);
    }

    public Quote updateQuoteforPrice(Quote quote) {
        // Calcular el nuevo precio total de la cotización
        int newPrice = 0;
        for (Product product : quote.getProducts()) {
            newPrice += product.getPrice();
        }
        quote.setPrice(newPrice);
        // Actualizar la cotización en la base de datos
        return quoteRepository.save(quote);
    }
}
