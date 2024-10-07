package com.example.productstore.productstore.controllers;

import com.example.productstore.productstore.models.Product;
import com.example.productstore.productstore.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerMVCTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	@Test
	public void testGetProductById() throws Exception {
		// Create a mock product
		Product product = new Product();
		product.setId(1L);
		product.setTitle("Sample Product");

		// Mock the behavior of productService to return the mock product
		when(productService.getProductById(1L)).thenReturn(product);

		// Perform a GET request to /product/1
		mockMvc.perform(get("/product/{id}", 1L)
				.contentType(MediaType.APPLICATION_JSON))
			.andDo(print()) // Prints the request and response
			.andExpect(status().isOk()) // Expecting HTTP 200 OK
			.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)) // Verifies content type is JSON
			.andExpect(jsonPath("$.id").value(1)) // Verifies the id field in JSON response
			.andExpect(jsonPath("$.name").value("Sample Product")); // Verifies the name field in JSON response
	}
}
