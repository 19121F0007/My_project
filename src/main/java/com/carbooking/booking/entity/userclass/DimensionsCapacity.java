package com.carbooking.booking.entity.userclass;

import jakarta.validation.constraints.PositiveOrZero;

public class DimensionsCapacity {
	
	@PositiveOrZero(message = "Length must be non-negative")
	private double length;
	
	@PositiveOrZero(message = "Width must be non-negative")
	private double width;

	@PositiveOrZero(message = "Height must be non-negative")
	private double height;

	@PositiveOrZero(message = "Seating capacity must be non-negative")
	private int seatingCapacity;

	@PositiveOrZero(message = "Trunk capacity must be non-negative")
	private double trunkCapacity;

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public double getTrunkCapacity() {
		return trunkCapacity;
	}

	public void setTrunkCapacity(double trunkCapacity) {
		this.trunkCapacity = trunkCapacity;
	}

	public DimensionsCapacity(@PositiveOrZero(message = "Length must be non-negative") double length,
			@PositiveOrZero(message = "Width must be non-negative") double width,
			@PositiveOrZero(message = "Height must be non-negative") double height,
			@PositiveOrZero(message = "Seating capacity must be non-negative") int seatingCapacity,
			@PositiveOrZero(message = "Trunk capacity must be non-negative") double trunkCapacity) {
		super();
		this.length = length;
		this.width = width;
		this.height = height;
		this.seatingCapacity = seatingCapacity;
		this.trunkCapacity = trunkCapacity;
	}

	public DimensionsCapacity() {
		super();
	}

	@Override
	public String toString() {
		return "DimensionsCapacity [length=" + length + ", width=" + width + ", height=" + height + ", seatingCapacity="
				+ seatingCapacity + ", trunkCapacity=" + trunkCapacity + "]";
	}
}
