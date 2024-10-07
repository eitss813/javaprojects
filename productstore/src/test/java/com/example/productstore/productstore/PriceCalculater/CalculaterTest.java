package com.example.productstore.productstore.PriceCalculater;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculaterTest {

	@Test
	@DisplayName("Testing 1+2=3")
	void add() {
		// 3a
		// 1. Arrange
		int n1 = 1;
		int n2 = 2;
		Calculater calculater = new Calculater();

		// 2. Act
		int result = calculater.add(n1, n2);

		// 3. Assert
		assertEquals(3, result);

//		if(result == 3){
//			System.out.println("Success");
//		}else {
//			System.out.println("Failure");
//
//		}
	}

	@Test
	void sub() {
	}

	@Test
	void mult() {
	}

	@Test
	void Test_DivideByZero_Exception() {
		// Arrange
		Calculater calculater = new Calculater();

		//Assert
		assertThrows(ArithmeticException.class, ()-> calculater.div(1,0));
	}
}
