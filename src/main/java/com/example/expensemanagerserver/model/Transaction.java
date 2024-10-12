package com.example.expensemanagerserver.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;
    private Timestamp date;
    private String description;
    @Enumerated(EnumType.STRING)
    private CategoryType type;
    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp modified_at;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name="wallet_id", nullable = false)
    private Wallet wallet;
}
