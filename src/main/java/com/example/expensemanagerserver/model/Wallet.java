package com.example.expensemanagerserver.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;

@Data
@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private WalletType type;
    private double balance;

    @ManyToOne
    @JoinColumn(name="currency_id", nullable = false)
    private Currency currency;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;


    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp modified_at;


}
