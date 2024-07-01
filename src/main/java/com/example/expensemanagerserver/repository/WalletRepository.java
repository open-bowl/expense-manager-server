package com.example.expensemanagerserver.repository;

import com.example.expensemanagerserver.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    List<Wallet> findWalletByUserId(Long userId);
}
