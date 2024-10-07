package com.example.demo.services;

import com.example.demo.exceptions.InvalidUserException;
import com.example.demo.models.Token;
import com.example.demo.models.User;
import com.example.demo.repos.TokenRepo;
import com.example.demo.repos.UserRepo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private TokenRepo tokenRepo;


	private String encodePassword(String rawPassword){
		return bCryptPasswordEncoder.encode(rawPassword);
	}

	public User signup(String email, String password, String name){
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setHashedPassword(encodePassword(password));

		return this.userRepo.save(user);

	}
	// Validate Token
	public User validateToken(String tokenValue){
		Optional<Token> token = this.tokenRepo.findByValueAndExpiryAtGreaterThan(tokenValue, new Date());

		if(token.isEmpty()){
			throw new RuntimeException("Invalid Token");
		}

		return token.get().getUser();

	}


	public Token login(String email, String password) throws InvalidUserException {

		// Valid user
		Optional<User> user = this.userRepo.findByEmail(email);
		if(user.isEmpty()){
			throw new UsernameNotFoundException("User not exist");
		}

		// Verify password
		if(!bCryptPasswordEncoder.matches(password, user.get().getHashedPassword())){
			throw new InvalidUserException("Invalid password");
		}

		// Generate token
		Token token = generateToken(user.get());

			tokenRepo.save(token);

		return token;
	}

	private Token generateToken(User user){
		Token token = new Token();

		token.setUser(user);
		token.setValue(RandomStringUtils.randomAlphabetic(10));

		LocalDate currentDate = LocalDate.now();
		LocalDate thirtyDaysLater =currentDate.plusDays(30);

		Date expiryAt = Date.from(thirtyDaysLater.atStartOfDay(ZoneId.systemDefault()).toInstant());

		token.setExpiryAt(expiryAt);

		return token;

	}

}
