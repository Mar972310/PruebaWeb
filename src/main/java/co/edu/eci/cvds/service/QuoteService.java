package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Quote;
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

    public Quote addQuote(Quote quote) {
        quote.setId(UUID.randomUUID().toString());
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
}
