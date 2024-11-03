package com.example.productstore.productstore.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDto {
	private String keyword;
	private int pageSize;
	private int pageNumber;
}
