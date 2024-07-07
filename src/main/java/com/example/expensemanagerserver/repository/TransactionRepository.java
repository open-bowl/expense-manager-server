package com.example.expensemanagerserver.repository;

import com.example.expensemanagerserver.model.Transaction;
import com.example.expensemanagerserver.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findTransactionByUserId(Long userId);
}
