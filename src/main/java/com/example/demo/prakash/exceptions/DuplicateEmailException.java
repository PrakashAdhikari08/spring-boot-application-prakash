package com.example.demo.prakash.exceptions;

public class DuplicateEmailException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1533690454334498133L;

	public DuplicateEmailException() {
		super();
	}

	public DuplicateEmailException(String arg) {
		super(arg);
	}
}
