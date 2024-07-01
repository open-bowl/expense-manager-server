package com.example.expensemanagerserver.repository;

import com.example.expensemanagerserver.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
