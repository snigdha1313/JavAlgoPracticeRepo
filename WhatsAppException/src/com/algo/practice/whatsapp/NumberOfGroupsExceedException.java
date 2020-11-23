package com.algo.practice.whatsapp;

public class NumberOfGroupsExceedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public NumberOfGroupsExceedException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
