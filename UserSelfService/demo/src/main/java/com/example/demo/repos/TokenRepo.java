package com.example.demo.repos;

import com.example.demo.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface TokenRepo extends JpaRepository<Token, Long> {
	Optional<Token> findByValueAndExpiryAtGreaterThan(String token, Date date);
}
