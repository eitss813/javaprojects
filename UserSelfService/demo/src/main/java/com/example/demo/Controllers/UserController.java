package com.example.demo.Controllers;

import com.example.demo.dtos.LoginDto;
import com.example.demo.dtos.SignUpDto;
import com.example.demo.dtos.UserDto;
import com.example.demo.dtos.ValidateTokenDto;
import com.example.demo.exceptions.InvalidUserException;
import com.example.demo.models.Token;
import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
	private UserService userService;

	public UserController(UserService userservice){
		this.userService = userservice;
	}

	@PostMapping("/signup")
	public UserDto signUp(@RequestBody SignUpDto signUpDto){

		User user = this.userService.signup(signUpDto.getEmail(), signUpDto.getPassword(), signUpDto.getName());

		return UserDto.from(user);
	}

	@PostMapping("/login")
	public Token signUp(@RequestBody LoginDto loginDto) throws InvalidUserException {


		return this.userService.login(loginDto.getEmail(), loginDto.getPassword());


	}

	@PostMapping("/validate_token")
	public UserDto validateToken(@RequestBody ValidateTokenDto validateTokenDto){

		return UserDto.from(this.userService.validateToken(validateTokenDto.getTokenValue()));
	}

	@PostMapping("/validate/token/{token}")
	public UserDto validate(@PathVariable String token) throws InvalidUserException {

		try{
			return UserDto.from(this.userService.validateToken(token));
		}catch (Exception e){
			return null;
		}
	}
}
