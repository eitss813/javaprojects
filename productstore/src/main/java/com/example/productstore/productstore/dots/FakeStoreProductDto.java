package com.example.productstore.productstore.dots;

import com.example.productstore.productstore.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
	private Long id;
	private String title;
	private double price;
	private String category;
	private String description;
	private String image;
}
