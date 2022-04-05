package com.foodbox.exception;

public class BuyNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BuyNotFoundException() {
	}

	public BuyNotFoundException(String message) {
		super(message);
	}
}
