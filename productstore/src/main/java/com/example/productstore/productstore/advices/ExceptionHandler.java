package com.example.productstore.productstore.advices;

import com.example.productstore.productstore.controllers.ProductController;
import com.example.productstore.productstore.dtos.ProductStoreExceptionDto;
import com.example.productstore.productstore.exceptions.InvalidTokenException;
import com.example.productstore.productstore.exceptions.ProductStoreException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.io.InvalidClassException;

@ControllerAdvice(assignableTypes = ProductController.class)
public class ExceptionHandler {


	@org.springframework.web.bind.annotation.ExceptionHandler(ProductStoreException.class)
	public ResponseEntity<ProductStoreExceptionDto> handleCustomException(){
		ProductStoreExceptionDto productStoreExceptionDto = new ProductStoreExceptionDto();
		productStoreExceptionDto.setErrorCode("PRODUCT_LIMIT_REACHED");
		productStoreExceptionDto.setMessage("Something went wrong");

		return new ResponseEntity<>(productStoreExceptionDto, HttpStatus.NOT_FOUND);
	}


	@org.springframework.web.bind.annotation.ExceptionHandler(InvalidTokenException.class)
	public ResponseEntity<String> handleInvalidTokenException(){
		return new ResponseEntity<String>("INVALID_TOKEN", HttpStatus.FORBIDDEN);
	}


//	@org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
//	public ResponseEntity<String> handleException(){
//		return new ResponseEntity<String>("Something went wrong on 3rd party side", HttpStatus.INTERNAL_SERVER_ERROR);
//	}

}
