package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService(){
		UserDetails normalUser = User.withUsername("raja")
			.password( passwordEncoder().encode("1234abcd"))
			.roles("NORMAL")
			.build();

		UserDetails adminUser = User.withUsername("admin")
			.password(passwordEncoder().encode("1234abcd"))
			.roles("ADMIN")
			.build();

		return new InMemoryUserDetailsManager(normalUser,adminUser);
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
			.authorizeHttpRequests()
//			.requestMatchers("home/admin")
//			.hasRole("ADMIN")
//			.requestMatchers("home/customer")
//			.hasRole("NORMAL")
//			.requestMatchers("/home/public")
//			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin();

		return httpSecurity.build();
	}
}
