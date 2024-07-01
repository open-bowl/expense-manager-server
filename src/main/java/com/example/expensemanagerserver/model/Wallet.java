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
    private WalltetType type;
    private double balance;
    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp modified_at;

    @ManyToOne
    @JoinColumn(name="currency_id", nullable = false)
    private Currency currency;

    @OneToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

}
