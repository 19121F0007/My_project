package com.carbooking.booking.Exception;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends Exception {
	public CustomerNotFoundException(String message) {
		super(message);
	}
}
