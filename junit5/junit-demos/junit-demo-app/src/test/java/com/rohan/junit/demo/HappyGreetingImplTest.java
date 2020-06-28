package com.rohan.junit.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Example to show test lifecycle.
 * @author rohan
 *
 */
public class HappyGreetingImplTest {

	private Greeting greeting;
	
	@BeforeClass
	public static void setupOnce(){
		System.out.println("In setupOnce()");
	}
	
	@Before
	public void setup(){
		System.out.println("In setup()");
		greeting = new HappyGreetingImpl();
	}
	
	@Test
	public void greetShouldReturnValidOutput() {
		System.out.println("In greetShouldReturnValidOutput()");
		String result = greeting.greet("Junit");
		assertNotNull(result);
		assertEquals("Hi Junit! So happy to meet you !!", result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void greetWithValidationShouldThrowException_For_NameIsNull() {
		System.out.println("In greetWithValidationShouldThrowException_For_NameIsNull()");
		greeting.greetWithValidation(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void greetWithValidationShouldThrowException_For_NameIsEmpty() {
		System.out.println("In greetWithValidationShouldThrowException_For_NameIsEmpty()");
		greeting.greetWithValidation("");
	}
	
	@After
	public void tearDown() {
		System.out.println("In tearDown()");
		greeting = null;
	}
	
	@AfterClass
	public static void tearDownOnce(){
		System.out.println("In tearDownOnce()");
	}
}
