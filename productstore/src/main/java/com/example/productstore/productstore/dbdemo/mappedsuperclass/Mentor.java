package com.example.productstore.productstore.dbdemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Mentor extends User {
	private int noOfClasses;

}
