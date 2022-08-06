package com.rockgustavo.service;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Not Found ID:"+ id);
	}

}

