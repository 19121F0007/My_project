package com.carbooking.booking.Exception;

@SuppressWarnings("serial")
public class CarNotFoundException extends Exception {
	public CarNotFoundException() {
		super();
	}
	public CarNotFoundException(String message) {
		super(message);
	}
	public CarNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
