package com.example.productstore.productstore.services;

import com.example.productstore.productstore.models.Category;
import com.example.productstore.productstore.repositary.CategoryRepository;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService{
	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}


	@Override
	public Category saveCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	@Override
	public Category getCategory(Long id) {
		return null;
	}
}
