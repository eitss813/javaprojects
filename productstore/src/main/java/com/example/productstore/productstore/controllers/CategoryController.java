package com.example.productstore.productstore.controllers;

import com.example.productstore.productstore.models.Category;
import com.example.productstore.productstore.services.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping("/create")
	public Category saveCategory(@RequestBody Category category){

		//TO-DO VALIDATION

		return this.categoryService.saveCategory(category);
	}
}
