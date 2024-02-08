package com.carbooking.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@NotNull(message = "Car Part is required")
	private CarPart carPart;
	
	@Min(value = 1, message = "Quantity must be at least 1")
	private int quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public CartItem(Long id, @NotNull(message = "Car Part is required") CarPart carPart,
			@Min(value = 1, message = "Quantity must be at least 1") int quantity) {
		super();
		this.id = id;
		this.carPart = carPart;
		this.quantity = quantity;
	}

	public CartItem() {
		super();
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", carPart=" + carPart + ", quantity=" + quantity + "]";
	}
}
