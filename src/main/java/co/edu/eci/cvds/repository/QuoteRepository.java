package co.edu.eci.cvds.repository;
import co.edu.eci.cvds.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, String> {
    public List<Quote> findByQuoteId(String QuoteId);
}



