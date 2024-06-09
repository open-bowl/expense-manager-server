package com.example.expensemanagerserver.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CategoryType type;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
