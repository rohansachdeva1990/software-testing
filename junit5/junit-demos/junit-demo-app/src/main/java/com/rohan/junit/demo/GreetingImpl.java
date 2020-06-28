package com.rohan.junit.demo;

public class GreetingImpl implements Greeting {

	@Override
	public String greet(String name) {
		return "Hello " + name;
	}

	@Override
	public String greetWithValidation(String name) throws IllegalArgumentException {

		if (null == name || name.length() == 0) {
			throw new IllegalArgumentException();
		}

		return "Hello " + name;
	}

}
