package com.samples.exception;

public class UserNamenotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserNamenotFoundException() {
		super();
	}
	public UserNamenotFoundException(String message) {
		super(message);
	}
}
