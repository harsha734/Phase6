package com.foodbox.exception;

public class FooditemNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public FooditemNotFoundException() {

	}

	public FooditemNotFoundException(String message) {
		super(message);
	}
}
