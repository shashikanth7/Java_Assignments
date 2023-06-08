package com.dedalus.exceptions;



public class UserNotFoundException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		System.out.println("From unfe constr");

	}

	@Override
	public String toString() {
		return "UserNotFoundException tostring";
	}

}
