package com.example.productstore.productstore.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductStoreExceptionDto {
	private String message;
	private String errorCode;
}
