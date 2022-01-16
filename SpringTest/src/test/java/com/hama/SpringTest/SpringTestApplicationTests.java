package com.hama.SpringTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hama.SpringTest.testing.Calculator;

@SpringBootTest
class SpringTestApplicationTests {

	@Test
	void testAddTwoPositiveNumbers() {
		
		//Arrange
		
		int a = 2;
		int b = 3;
		Calculator calculator = new Calculator();
		
		
		//Act
		
		int somme = calculator.add(a, b);
		
		
		//Assert
		assertEquals(5, somme);
	}

}
