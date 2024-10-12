package com.example.expensemanagerserver.controller;

import com.example.expensemanagerserver.exception.BadRequestException;
import com.example.expensemanagerserver.model.CategoryType;
import com.example.expensemanagerserver.model.Transaction;
import com.example.expensemanagerserver.model.Wallet;
import com.example.expensemanagerserver.repository.TransactionRepository;
import com.example.expensemanagerserver.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private WalletRepository walletRepository;


    @GetMapping("/transaction")
    public ResponseEntity<Iterable<Transaction>> getTransaction() {
        Iterable<Transaction> transactions = transactionRepository.findAll();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/transaction/{userId}")
    public ResponseEntity<Iterable<Transaction>> getTransactionByUserId(@PathVariable("userId") Long userId) {
        Iterable<Transaction> transactions = transactionRepository.findTransactionByUserId(userId);
        return ResponseEntity.ok(transactions);
    }

    @PostMapping("/transaction")
    @Transactional
    public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionRepository.save(transaction);
        // update wallet
        Optional<Wallet> wallet = walletRepository.findById(transaction.getWallet().getId());
        if (wallet.isPresent()) {
            Wallet walletDetails = wallet.get();
            CategoryType categoryType = transaction.getType();
            double currentBalance = wallet.get().getBalance();
            if (categoryType.equals(CategoryType.INCOME)) {
                currentBalance = currentBalance + transaction.getAmount();
            } else {
                currentBalance = currentBalance - transaction.getAmount();
            }
            walletDetails.setBalance(currentBalance);
            walletRepository.save(walletDetails);
        }

        throw new BadRequestException("Wallet not found");
    }
}
