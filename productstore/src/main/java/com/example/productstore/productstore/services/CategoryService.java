package com.example.productstore.productstore.services;

import com.example.productstore.productstore.models.Category;

public interface CategoryService {
	public Category saveCategory(Category category);
	public Category getCategory(Long id);
}
