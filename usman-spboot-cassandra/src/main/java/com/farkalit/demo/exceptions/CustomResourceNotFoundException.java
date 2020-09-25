package com.farkalit.demo.exceptions;

public class CustomResourceNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomResourceNotFoundException() {
		super();
	}

	public CustomResourceNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CustomResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomResourceNotFoundException(String message) {
		super(message);
	}

	public CustomResourceNotFoundException(Throwable cause) {
		super(cause);
	}

}
