package com.example.productstore.productstore.controllers;

import com.example.productstore.productstore.exceptions.InvalidTokenException;
import com.example.productstore.productstore.exceptions.ProductStoreException;
import com.example.productstore.productstore.models.Product;
import com.example.productstore.productstore.services.ProductService;
import com.example.productstore.productstore.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private TokenService tokenService;

	@GetMapping("/{id}")
	// ideally it should return Product DTO
	public ResponseEntity<Product> getProductById( @RequestHeader("token") String token, @PathVariable("id") Long id) throws InvalidTokenException, ProductStoreException {
		if(id > 100){
			throw new ProductStoreException("There can be max 100 product!");
		}

		// Validate token
		if(!tokenService.validateToken(token)){
			System.out.println("Token: " + token);
			throw new InvalidTokenException("Token is not valid");
		}

		return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);

	}

//	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductStoreException {
//		//return new ResponseEntity<Product>(new Product(), HttpStatus.OK);
//		if(id > 100){
//			throw new ProductStoreException("There can be max 100 product!");
//		}
//try{
//		return new ResponseEntity<>(this.productService.getProductById(id), HttpStatus.OK);
//		}catch (Exception e){
//			return new ResponseEntity<String>("Some error occurred at 3rd party end" + e.getMessage(), HttpStatus.OK)
//		}
//
//	}

	@GetMapping()
	public List<Product> getAllProduct(){
		return this.productService.getAllProducts();
	}
	@PostMapping("/create")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		return new ResponseEntity<>(this.productService.createProduct(product), HttpStatus.OK);
//		try {
//			return new ResponseEntity<>(this.productService.createProduct(product), HttpStatus.OK);
//		}catch (Exception e){
//			return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
//		}

	}

	@PutMapping("/{id}")
	public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){

		return this.productService.updateProduct(id, product);
	}

	@PatchMapping("/{id}")
	public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
		return new Product();
	}

	@DeleteMapping("/{id}")
	public Product deleteProduct(@PathVariable("id") Long id){

		return new Product();
	}

//	@ExceptionHandler(RuntimeException.class)
//	public ResponseEntity<String> handleException(){
//		return new ResponseEntity<String>("Something went 3rd party side", HttpStatus.INTERNAL_SERVER_ERROR);
//	}

}
