package com.example.productstore.productstore.dbdemo.joinedtable;

import jakarta.persistence.Entity;

@Entity(name="jt_ta")
public class TA extends User {
	private String noSessions;
}
