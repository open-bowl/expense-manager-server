package com.example.expensemanagerserver.controller;

import com.example.expensemanagerserver.model.Currency;
import com.example.expensemanagerserver.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.Optional;

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

    @PatchMapping("/currency/{id}")
    public ResponseEntity<Currency> updateCurrency(@RequestBody Currency currency, @PathVariable("id") Long id) {
        try {
            Optional<Currency> updatedCurrency = currencyRepository.findById(id);
            if (updatedCurrency.isPresent()) {
                Currency existingValue = updatedCurrency.get();
                Field[] fields = currency.getClass().getDeclaredFields();
                for (Field field : fields) {
                    // To access the private member
                    field.setAccessible(true);
                    Object value = field.get(currency);
                    if (value != null) {
                        field.set(existingValue, value);
                    }
                }
                // Save the updated entity back to the repository
                return ResponseEntity.ok(currencyRepository.save(existingValue));
            } else {
                return ResponseEntity.ok(currencyRepository.save(currency));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
