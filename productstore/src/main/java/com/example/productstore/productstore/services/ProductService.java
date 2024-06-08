package com.example.productstore.productstore.services;

import com.example.productstore.productstore.models.Product;

import java.util.List;

public interface ProductService {
	public Product getProductById(Long id);
	public List<Product> getAllProducts();
	public Product updateProduct(Long id, Product product);
	public Product replaceProduct(Long id);
	public Product deleteProduct(Long id);
	public Product createProduct(Product product);

}
