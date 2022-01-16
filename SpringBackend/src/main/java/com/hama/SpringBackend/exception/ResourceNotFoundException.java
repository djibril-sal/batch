package com.hama.SpringBackend.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -804217249215329944L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
