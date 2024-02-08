package com.carbooking.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class CarPart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Name is required")
	@Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
	private String name;
	
	@NotBlank(message = "Description is required")
	@Size(min = 5, max = 255, message = "Description must be between 5 and 255 characters")
	private String description;

	@NotNull(message = "Price is required")
	@Positive(message = "Price must be positive")
	private Double price;

	public CarPart(Long id,
			@NotBlank(message = "Name is required") @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters") String name,
			@NotBlank(message = "Description is required") @Size(min = 5, max = 255, message = "Description must be between 5 and 255 characters") String description,
			@NotNull(message = "Price is required") @Positive(message = "Price must be positive") Double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public CarPart() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CarPart [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	} 
}
