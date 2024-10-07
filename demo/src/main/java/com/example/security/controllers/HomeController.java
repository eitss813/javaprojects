package com.example.security.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

	@GetMapping("/public")
	public ResponseEntity<String> publicUser(){
		return ResponseEntity.ok("This is normal user");
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public ResponseEntity<String> adminUser(){
		return ResponseEntity.ok("This is admin page");
	}

	@PreAuthorize("hasRole('NORMAL')")
	@GetMapping("/customer")
	public ResponseEntity<String> customer(){
		return ResponseEntity.ok("This is customer page");
	}

}
