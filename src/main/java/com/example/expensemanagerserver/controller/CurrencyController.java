package com.example.expensemanagerserver.controller;

import com.example.expensemanagerserver.model.Currency;
import com.example.expensemanagerserver.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurrencyController {

    @Autowired
    private CurrencyRepository currencyRepository;

    @GetMapping("/currency")
    public ResponseEntity<Iterable<Currency>> getCurrency() {
        Iterable<Currency> currencies = currencyRepository.findAll();
        return ResponseEntity.ok(currencies);
    }

    @PostMapping("/currency")
    public ResponseEntity<Currency> createCurrency(@RequestBody Currency currency) {
        Currency savedCurrency = currencyRepository.save(currency);
        return ResponseEntity.ok(savedCurrency);
    }

}
