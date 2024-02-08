package com.carbooking.booking.Exception;

@SuppressWarnings("serial")
public class UserEmailAlreadyExistsException extends Exception {
	public UserEmailAlreadyExistsException(String message) {
	    super(message);
	} 
}
