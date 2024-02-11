package com.carbooking.booking.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CarPurchase {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    
    @ManyToOne
    @JoinColumn(name = "salesperson_id")
    private Salesperson salesperson;
    
    private LocalDateTime purchaseDateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Salesperson getSalesperson() {
		return salesperson;
	}

	public void setSalesperson(Salesperson salesperson) {
		this.salesperson = salesperson;
	}

	public LocalDateTime getPurchaseDateTime() {
		return purchaseDateTime;
	}

	public void setPurchaseDateTime(LocalDateTime purchaseDateTime) {
		this.purchaseDateTime = purchaseDateTime;
	}

	public CarPurchase(Long id, Car car, Salesperson salesperson, LocalDateTime purchaseDateTime) {
		super();
		this.id = id;
		this.car = car;
		this.salesperson = salesperson;
		this.purchaseDateTime = purchaseDateTime;
	}

	@Override
	public String toString() {
		return "CarPurchase [id=" + id + ", car=" + car + ", salesperson=" + salesperson + ", purchaseDateTime="
				+ purchaseDateTime + "]";
	}

	public CarPurchase() {
		super();
	} 
}
