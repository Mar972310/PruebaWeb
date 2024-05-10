package co.edu.eci.cvds.controller;

import co.edu.eci.cvds.model.Configuration;
import co.edu.eci.cvds.model.Quote;
import co.edu.eci.cvds.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/api/Quote")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    
    public QuoteController(QuoteService quoteService){
        this.quoteService = quoteService;
    }
    
    @GetMapping("")
    public String toList(Model model){
        List<Quote> quotes = quoteService.getAllQuotes();
        model.addAttribute("quotes", quotes);
        return "listQuotes";
    }


}
