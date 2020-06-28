package com.rohan.junit.demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class GreetingImplTest {

	@Test
	public void greetShouldReturnValidOutput() {
		Greeting greeting = new GreetingImpl();
		String result = greeting.greet("Junit");

		assertNotNull(result);
		assertEquals("Hello Junit", result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void greetWithValidationShouldThrowException_For_NameIsNull() {
		Greeting greeting = new GreetingImpl();
		greeting.greetWithValidation(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void greetWithValidationShouldThrowException_For_NameIsEmpty() {
		Greeting greeting = new GreetingImpl();
		greeting.greetWithValidation("");
	}

}
