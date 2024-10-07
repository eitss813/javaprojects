package com.example.productstore.productstore.controllers;

import com.example.productstore.productstore.exceptions.ProductStoreException;
import com.example.productstore.productstore.models.Product;
import com.example.productstore.productstore.services.FakeProductService;
import com.example.productstore.productstore.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

	@MockBean
	//FakeProductService productService;
	ProductService productService;

	@Autowired
	ProductController productController;

	@BeforeEach
	void setup(){
		Product product = new Product();
		product.setId(2L);
		product.setTitle("Laptop1");

		// Rule
		//when(productService.getProductById(any(Long.class))).thenCallRealMethod();
		when(productService.getProductById(any(Long.class))).thenReturn(product);
	}

	@Test
	void Test_WhenGetProductByIdIsCalled_ThenReturnProduct() throws ProductStoreException {
		// Arrange

		//Act
		ResponseEntity<Product> responseEntity = productController.getProductById(2L);

		// Assert
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertNotNull(responseEntity);
		assertNotNull(responseEntity.getBody());
		assertEquals(2L, responseEntity.getBody().getId());
		assertEquals("Laptop1", responseEntity.getBody().getTitle());
	}
	@Test
	void Test_WhenGetProductByIdIsCalled_ThenReturnException(){
		//Rule
		when(productService.getProductById(any(Long.class))).thenThrow(new RuntimeException(("Something went")));

		assertThrows(RuntimeException.class, ()->productController.getProductById(2L));
	}
}
