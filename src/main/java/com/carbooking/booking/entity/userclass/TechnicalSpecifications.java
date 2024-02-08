package com.carbooking.booking.entity.userclass;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class TechnicalSpecifications {
	 
	 @NotBlank(message = "Engine type cannot be blank")
	 private String engineType;
	 
	 @Positive(message = "Engine capacity must be positive")
	 private double engineCapacity;

	 @PositiveOrZero(message = "Mileage must be non-negative")
	 private double mileage;

	 @NotBlank(message = "Fuel type cannot be blank")
	 private String fuelType;

	 @NotBlank(message = "Transmission type cannot be blank")
	 private String transmissionType;

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public double getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(double engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}

	public TechnicalSpecifications(@NotBlank(message = "Engine type cannot be blank") String engineType,
			@Positive(message = "Engine capacity must be positive") double engineCapacity,
			@PositiveOrZero(message = "Mileage must be non-negative") double mileage,
			@NotBlank(message = "Fuel type cannot be blank") String fuelType,
			@NotBlank(message = "Transmission type cannot be blank") String transmissionType) {
		super();
		this.engineType = engineType;
		this.engineCapacity = engineCapacity;
		this.mileage = mileage;
		this.fuelType = fuelType;
		this.transmissionType = transmissionType;
	}

	public TechnicalSpecifications() {
		super();
	}

	@Override
	public String toString() {
		return "TechnicalSpecifications [engineType=" + engineType + ", engineCapacity=" + engineCapacity + ", mileage="
				+ mileage + ", fuelType=" + fuelType + ", transmissionType=" + transmissionType + "]";
	} 
}
