package com.apil.stock.dbservice.resource;

import com.apil.stock.dbservice.model.Quote;
import com.apil.stock.dbservice.model.Quotes;
import com.apil.stock.dbservice.repository.QuotesRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DBServiceResource {

    private QuotesRepository quotesRespository;

    public DBServiceResource(QuotesRepository quotesRespository) {
        this.quotesRespository = quotesRespository;
    }

    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username") final String username){

       return getQuotesByUserName(username);

    }

    @PostMapping("/add")
    public List<String> add(@RequestBody final Quotes quotes){
        quotes.getQuotes()
                .stream()
                .map(quote -> new Quote(quotes.getUserName(), quote))
                .forEach(quote -> quotesRespository.save(quote));

        return getQuotesByUserName(quotes.getUserName());
    }

    @PostMapping("/delete/{username}")
    public List<String> delete(@PathVariable("username") final String username){

        List<Quote> quotes = quotesRespository.findByUserName(username);
        deleteUserName(quotes);
        return getQuotesByUserName(username);
    }

    private List<String> getQuotesByUserName(@PathVariable("username") String username) {
        return quotesRespository.findByUserName(username)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());
    }

    private void deleteUserName(List<Quote> quotes) {
        for(Quote quote : quotes){
            quotesRespository.delete(quote);
        }
    }
}
