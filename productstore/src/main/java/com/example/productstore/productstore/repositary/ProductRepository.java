package com.example.productstore.productstore.repositary;

import com.example.productstore.productstore.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
