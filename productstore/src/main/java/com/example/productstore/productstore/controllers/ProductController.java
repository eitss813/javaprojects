package com.example.productstore.productstore.controllers;

import com.example.productstore.productstore.models.Product;
import com.example.productstore.productstore.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
	private ProductService productService;

	ProductController(ProductService productService){
		this.productService = productService;

	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long id){
		return this.productService.getProductById(id);
	}

	@GetMapping()
	public List<Product> getAllProduct(){
		return List.of(new Product());
	}
	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product){

		return new Product();
	}

	@PutMapping("/{id}")
	public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){

		return new Product();
	}

	@PatchMapping("/{id}")
	public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){

		return new Product();
	}

	@DeleteMapping("/{id}")
	public Product deleteProduct(@PathVariable("id") Long id){

		return new Product();
	}
}
