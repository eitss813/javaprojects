package com.example.productstore.productstore.dbdemo.joinedtable;

import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class User {
	@Id
	private Long id;
	private String email;
	private  String password;
}
