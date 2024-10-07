package com.example.productstore.productstore.dbdemo.joinedtable;

import jakarta.persistence.Entity;

@Entity(name="jt_ins")
public class Instructor extends User {
	private String specialization;
}
