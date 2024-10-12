package com.example.expensemanagerserver.controller;

import com.example.expensemanagerserver.model.Currency;
import com.example.expensemanagerserver.model.Wallet;
import com.example.expensemanagerserver.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {
    @Autowired
    private WalletRepository walletRepository;

    @GetMapping("/wallet")
    public ResponseEntity<Iterable<Wallet>> getCurrency() {
        Iterable<Wallet> wallets = walletRepository.findAll();
        return ResponseEntity.ok(wallets);
    }

    @GetMapping("/wallet/{userId}")
    public ResponseEntity<Iterable<Wallet>> getWallet(@PathVariable("userId") Long userId){
        Iterable<Wallet> wallets =  walletRepository.findWalletByUserId(userId);
        return ResponseEntity.ok(wallets);
    }

    @GetMapping("/wallet/user/{userId}")
    public ResponseEntity<Iterable<Wallet>> getUserWallets(@PathVariable("userId") Long userId){
        Iterable<Wallet> wallets =  walletRepository.findWalletByUserId(userId);
        return ResponseEntity.ok(wallets);
    }

    @PostMapping("/wallet")
    public ResponseEntity<Wallet> saveWallet(@RequestBody Wallet wallet){
        Wallet savedWallet = walletRepository.save(wallet);
        return ResponseEntity.ok(savedWallet);
    }
}
