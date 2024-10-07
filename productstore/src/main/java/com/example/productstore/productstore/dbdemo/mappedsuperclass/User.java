package com.example.productstore.productstore.dbdemo.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class User {
	@Id
	private Long id;
	private String email;
	private  String password;
}
