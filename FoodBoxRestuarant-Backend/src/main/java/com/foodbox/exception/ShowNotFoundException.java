package com.foodbox.exception;

public class ShowNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ShowNotFoundException() {
	}

	public ShowNotFoundException(String message) {
		super(message);
	}
}
