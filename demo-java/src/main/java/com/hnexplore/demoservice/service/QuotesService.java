package com.hnexplore.demoservice.service;

import com.hnexplore.demoservice.model.Quote;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuotesService {

    public List<Quote> getQuotesOfTheDay() {
        List<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote(1, "Caroline Rhea", "My favorite machine at the gym is the vending machine."));
        quotes.add(new Quote(2, "Pablo Picasso", "The world today doesn't make sense, so why should I paint pictures that do?"));
        quotes.add(new Quote(3, "Steven Wright", "What's another word for Thesaurus?"));

        return quotes;
    }
}
