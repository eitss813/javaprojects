package com.example.productstore.productstore.services;

import com.example.productstore.productstore.models.Category;
import com.example.productstore.productstore.models.Product;
import com.example.productstore.productstore.repositary.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
@Primary
public class SelfProductService implements ProductService {

	private final ProductRepository productRepository;
	private final CategoryService categoryService;

	public SelfProductService(ProductRepository productRepository, CategoryService categoryService) {
		this.productRepository = productRepository;
		this.categoryService = categoryService;
	}

	@Override
	public Product getProductById(Long id) {
		Optional<Product> optionalProduct = this.productRepository.findById(id);

		return optionalProduct.orElse(null);

	}

	@Override
	public List<Product> getAllProducts() {
		return null;
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		return null;
	}

	@Override
	public Product replaceProduct(Long id) {
		return null;
	}

	@Override
	public Product deleteProduct(Long id) {
		return null;
	}

	@Override
	public Product createProduct(Product product) {
		try{
			Category category = product.getCategory();

			if(category.getId() == null){
				Category savedCategory = this.categoryService.saveCategory(category);
				product.setCategory(savedCategory);
			}
		}catch (NullPointerException e){
			//System.out.println(e.getMessage());
			throw new NullPointerException();
		}


		return this.productRepository.save(product);
	}
}
