package com.rohan.junit.demo;

public interface Greeting {
	public String greet(String name);
	
	public String greetWithValidation(String name) throws IllegalArgumentException;
}
