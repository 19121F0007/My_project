package com.carbooking.booking.DTO;

import com.carbooking.booking.entity.CarPart;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CartItemRequest {
	
	@NotNull(message = "Car Part is required")
	private CarPart carPart;
	
	@Min(value = 1, message = "Quantity must be at least 1")
	private int quantity;

	public CarPart getCarPart() {
		return carPart;
	}

	public void setCarPart(CarPart carPart) {
		this.carPart = carPart;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CartItemRequest(@NotNull(message = "Car Part is required") CarPart carPart,
			@Min(value = 1, message = "Quantity must be at least 1") int quantity) {
		super();
		this.carPart = carPart;
		this.quantity = quantity;
	}

	public CartItemRequest() {
		super();
	}

	@Override
	public String toString() {
		return "CartItemRequest [carPart=" + carPart + ", quantity=" + quantity + "]";
	}
	
	
}