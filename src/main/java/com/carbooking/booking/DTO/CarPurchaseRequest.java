package com.carbooking.booking.DTO;

import java.time.LocalDateTime;

public class CarPurchaseRequest {
	
	private Long carId;
	private LocalDateTime purchaseDateTime;
	
	public Long getCarId() {
		return carId;
	}
	public void setCarId(Long carId) {
		this.carId = carId;
	}
	public LocalDateTime getpurchaseDateTime() {
		return purchaseDateTime;
	}
	public void setpurchaseDateTime(LocalDateTime purchaseDateTime) {
		this.purchaseDateTime = purchaseDateTime;
	}
	public CarPurchaseRequest(Long carId, LocalDateTime purchaseDateTime) {
		super();
		this.carId = carId;
		this.purchaseDateTime = purchaseDateTime;
	}
	public CarPurchaseRequest() {
		super();
	}
	@Override
	public String toString() {
		return "CarPurchaseRequest [carId=" + carId + ", purchaseDateTime=" + purchaseDateTime + "]";
	}
	
}
