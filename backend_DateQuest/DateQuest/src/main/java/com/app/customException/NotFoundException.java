package com.app.customException;

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException {
	public  NotFoundException(String msg) {
		super(msg);
	}
	

}
