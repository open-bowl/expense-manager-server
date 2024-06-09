package com.example.expensemanagerserver.repository;

import com.example.expensemanagerserver.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
