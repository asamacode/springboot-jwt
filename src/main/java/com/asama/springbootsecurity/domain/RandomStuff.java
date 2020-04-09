package com.asama.springbootsecurity.domain;

public class RandomStuff {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RandomStuff(String message) {
		super();
		this.message = message;
	}

	public RandomStuff() {
		super();
	}

}
