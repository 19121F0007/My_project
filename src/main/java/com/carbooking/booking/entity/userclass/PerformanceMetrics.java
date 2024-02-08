package com.carbooking.booking.entity.userclass;

import jakarta.validation.constraints.Positive;

public class PerformanceMetrics {
	
	@Positive(message = "Fuel efficiency must be positive")
	private double fuelEfficiency;
	
	@Positive(message = "Top speed must be positive")
	private int topSpeed;

	@Positive(message = "Acceleration must be positive")
	private double acceleration;

	public double getFuelEfficiency() {
		return fuelEfficiency;
	}

	public void setFuelEfficiency(double fuelEfficiency) {
		this.fuelEfficiency = fuelEfficiency;
	}

	public int getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}

	public double getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}

	public PerformanceMetrics(@Positive(message = "Fuel efficiency must be positive") double fuelEfficiency,
			@Positive(message = "Top speed must be positive") int topSpeed,
			@Positive(message = "Acceleration must be positive") double acceleration) {
		super();
		this.fuelEfficiency = fuelEfficiency;
		this.topSpeed = topSpeed;
		this.acceleration = acceleration;
	}

	public PerformanceMetrics() {
		super();
	}

	@Override
	public String toString() {
		return "PerformanceMetrics [fuelEfficiency=" + fuelEfficiency + ", topSpeed=" + topSpeed + ", acceleration="
				+ acceleration + "]";
	}
	
	
}
