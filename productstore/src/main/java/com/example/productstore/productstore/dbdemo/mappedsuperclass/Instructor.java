package com.example.productstore.productstore.dbdemo.mappedsuperclass;

import jakarta.persistence.Entity;

@Entity(name="map_ins")
public class Instructor extends User{
	private String specialization;
}
