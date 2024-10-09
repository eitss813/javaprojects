package com.example.demo.security.services;

import com.example.demo.models.User;
import com.example.demo.repos.UserRepo;
import com.example.demo.security.repos.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = this.userRepo.findByEmail(username);

		if(user.isEmpty()){
			throw new UsernameNotFoundException("User not found with " + username);
		}

		return new CustomUserDetails(user.get());
	}
}
