package com.carbooking.booking.Exception;

@SuppressWarnings("serial")
public class CarServiceException extends RuntimeException {
	public CarServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
