package com.carbooking.booking.entity.userclass;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class BasicInformation {
	
	@NotBlank(message = "Brand cannot be blank")
    private String brand;
	
	@NotBlank(message = "Brand cannot be blank")
    private String model;
	
	@Min(value = 1900, message = "year must be greater than 1900")
    private int year;
	
	@NotBlank(message = "Color cannot be blank")
    private String color;
	
	@Min(value = 0, message = "Brand cannot be blank")
    private double price;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public BasicInformation(@NotBlank(message = "Brand cannot be blank") String brand,
			@NotBlank(message = "Brand cannot be blank") String model,
			@Min(value = 1900, message = "year must be greater than 1900") int year,
			@NotBlank(message = "Color cannot be blank") String color,
			@Min(value = 0, message = "Brand cannot be blank") double price) {
		super();
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.color = color;
		this.price = price;
	}

	public BasicInformation() {
		super();
	}

	@Override
	public String toString() {
		return "BasicInformation [brand=" + brand + ", model=" + model + ", year=" + year + ", color=" + color
				+ ", price=" + price + "]";
	}
}
