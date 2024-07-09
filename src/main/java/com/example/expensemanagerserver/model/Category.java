package com.example.expensemanagerserver.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Category {
    @Valid

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Name is required")
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Type is required")
  
    private CategoryType type;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "User is required")
  
    private User user;
}
