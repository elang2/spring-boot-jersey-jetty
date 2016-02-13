package com.sample.elan.impl.exception;

/**
 * Custom exception for scenarios when data requested is not found.
 * 
 * @author elang2@gmail.com
 */
public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4896387052452779192L;

	public DataNotFoundException(String exceptionMessage) {
		super(exceptionMessage);
	}

}
