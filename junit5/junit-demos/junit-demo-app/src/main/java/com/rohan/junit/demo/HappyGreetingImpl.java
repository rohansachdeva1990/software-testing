package com.rohan.junit.demo;

public class HappyGreetingImpl implements Greeting {

	@Override
	public String greet(String name) {

		return "Hi " + name + "! So happy to meet you !!";
	}

	@Override
	public String greetWithValidation(String name) throws IllegalArgumentException {

		if (null == name || name.length() == 0) {
			throw new IllegalArgumentException();
		}

		return "Hi " + name + "! So happy to meet you !!";
	}

}
