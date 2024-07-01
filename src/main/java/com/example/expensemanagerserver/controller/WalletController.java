package com.example.expensemanagerserver.controller;

import com.example.expensemanagerserver.model.User;
import com.example.expensemanagerserver.model.Wallet;
import com.example.expensemanagerserver.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {
    @Autowired
    private WalletRepository walletRepository;

    @GetMapping("/wallet/{id}")
    public ResponseEntity<Iterable<Wallet>> getWallet(@PathVariable Long id){
        Iterable<Wallet> wallets =  walletRepository.findWalletByUserId(id);
        return ResponseEntity.ok(wallets);
    }

    @PostMapping("/wallet")
    public ResponseEntity<Wallet> saveWallet(@RequestBody Wallet wallet){
        Wallet savedWallet = walletRepository.save(wallet);
        return ResponseEntity.ok(savedWallet);
    }
}
