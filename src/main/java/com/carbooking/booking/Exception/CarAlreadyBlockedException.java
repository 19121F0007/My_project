package com.carbooking.booking.Exception;

@SuppressWarnings("serial")
public class CarAlreadyBlockedException extends Exception {
	public CarAlreadyBlockedException(String message) {
		super(message);
	}
}
