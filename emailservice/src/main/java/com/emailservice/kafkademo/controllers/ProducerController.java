package com.emailservice.kafkademo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/send")
public class ProducerController {

	@GetMapping("/{msg}")
	public String sendMessage(@PathVariable("msg") String msg){
		

	}
}
