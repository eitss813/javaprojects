package com.example.productstore.productstore.repositary;

import com.example.productstore.productstore.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
