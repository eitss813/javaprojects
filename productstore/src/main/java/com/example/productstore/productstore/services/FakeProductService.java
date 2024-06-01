package com.example.productstore.productstore.services;

import com.example.productstore.productstore.dots.FakeStoreProductDto;
import com.example.productstore.productstore.models.Category;
import com.example.productstore.productstore.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FakeProductService implements ProductService {
	private RestTemplate restTemplate;

	@Autowired
	FakeProductService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public Product getProductById(Long id) {
		FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

		return convertFakeStoreProductToProduct(fakeStoreProductDto);
	}

	@Override
	public List<Product> getAllProducts() {
		return null;
	}

	@Override
	public Product updateProduct(Long id) {
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
		return null;
	}

	public Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProductDto) {
		Product product = new Product();
		product.setId(fakeStoreProductDto.getId());
		product.setTitle(fakeStoreProductDto.getTitle());
		product.setPrice(fakeStoreProductDto.getPrice());
		product.setDescription(fakeStoreProductDto.getDescription());
		product.setImage(fakeStoreProductDto.getImage());

		// Assuming Category has a constructor that takes an id and title
		Category category = new Category();

		category.setId(0L);
		category.setTitle(fakeStoreProductDto.getCategory());
		product.setCategory(category);

		return product;
	}

}
