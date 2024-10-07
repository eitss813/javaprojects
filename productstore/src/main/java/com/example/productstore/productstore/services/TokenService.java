package com.example.productstore.productstore.services;

import com.example.productstore.productstore.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TokenService {
	@Autowired
	private RestTemplate restTemplate;

	public boolean validateToken(String token){
		UserDto userDto = this.restTemplate.postForObject("http://localhost:8100/users/validate/token/"+token, null, UserDto.class);

		return userDto != null;
	}
}
