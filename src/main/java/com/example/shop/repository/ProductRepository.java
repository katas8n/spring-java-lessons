package com.example.shop.repository;

import com.example.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
    Product findByDescription(String description);
    Product findByPrice(Double price);
}
