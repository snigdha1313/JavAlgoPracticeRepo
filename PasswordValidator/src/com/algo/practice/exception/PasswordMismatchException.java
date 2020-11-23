package com.algo.practice.exception;

public class PasswordMismatchException extends Exception {

	private static final long serialVersionUID = 4781090396716633141L;
	
	private String message;

	public PasswordMismatchException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
