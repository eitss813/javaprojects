package com.example.productstore.productstore.services;

import com.example.productstore.productstore.dots.FakeStoreProductDto;
import com.example.productstore.productstore.models.Category;
import com.example.productstore.productstore.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeProductService implements ProductService {
	private final RestTemplate restTemplate;

	@Autowired
	FakeProductService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public Product getProductById(Long id) {

		FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

		assert fakeStoreProductDto != null;
		return convertFakeStoreProductToProduct(fakeStoreProductDto);
	}

	@Override
	public List<Product> getAllProducts() {
		FakeStoreProductDto[] fakeProdList = this.restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

		List<Product> productList = new ArrayList<>();
		assert fakeProdList != null;
		for(FakeStoreProductDto fakeStoreProductDto : fakeProdList){
			Product product = convertFakeStoreProductToProduct(fakeStoreProductDto);
			productList.add(product);
		}

		return productList;
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		FakeStoreProductDto fakeStoreProductDto = convertToFakeProductDto(product);

		 this.restTemplate.put("https://fakestoreapi.com/products/" + id, fakeStoreProductDto);

		return product;
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
		// Convert product to dto
        FakeStoreProductDto fakeStoreProductDto = convertToFakeProductDto(product);

		fakeStoreProductDto = this.restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreProductDto ,FakeStoreProductDto.class);

		assert fakeStoreProductDto != null;
		return convertFakeStoreProductToProduct(fakeStoreProductDto);
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

	/*
		Product to FakeProduct converter
		@param Product product
	 */

	public FakeStoreProductDto convertToFakeProductDto(Product product) {
		FakeStoreProductDto fakeProductDto = new FakeStoreProductDto();
		fakeProductDto.setId(product.getId());
		fakeProductDto.setTitle(product.getTitle());
		fakeProductDto.setPrice(product.getPrice());

		if(product.getCategory() != null){
			fakeProductDto.setCategory(product.getCategory().getTitle());
		}else{
			fakeProductDto.setCategory(null);
		}

		fakeProductDto.setDescription(product.getDescription());
		fakeProductDto.setImage(product.getImage());
		return fakeProductDto;
	}


}
