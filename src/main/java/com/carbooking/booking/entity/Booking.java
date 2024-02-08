package com.carbooking.booking.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @NotNull(message = "Car is required")
    @JoinColumn(name = "car_id")
    private Car car;

    @Future(message = "Booking date must be in the future")
    @NotNull(message = "Booking date is required")
    private LocalDateTime bookingDate;

	public Booking(Long id, @NotNull(message = "Car is required") Car car,
			@Future(message = "Booking date must be in the future") @NotNull(message = "Booking date is required") LocalDateTime bookingDate) {
		super();
		this.id = id;
		this.car = car;
		this.bookingDate = bookingDate;
	}

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

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Booking() {
		super();
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", car=" + car + ", bookingDate=" + bookingDate + "]";
	}
}