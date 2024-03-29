package com.carbooking.booking.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TestDrive {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    
    @ManyToOne
    @JoinColumn(name = "salesperson_id")
    private Salesperson salesperson;

    private LocalDateTime testDriveDateTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Car getCar() {
		return car;
	}

	public Salesperson getSalesperson() {
		return salesperson;
	}

	public void setSalesperson(Salesperson salesperson) {
		this.salesperson = salesperson;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public LocalDateTime getTestDriveDateTime() {
		return testDriveDateTime;
	}

	public void setTestDriveDateTime(LocalDateTime testDriveDateTime) {
		this.testDriveDateTime = testDriveDateTime;
	}


	public TestDrive(Long id, Car car, Salesperson salesperson, LocalDateTime testDriveDateTime) {
		super();
		this.id = id;
		this.car = car;
		this.salesperson = salesperson;
		this.testDriveDateTime = testDriveDateTime;
	}

	public TestDrive() {
		super();
	}

	@Override
	public String toString() {
		return "TestDrive [id=" + id + ", car=" + car + ", salesperson=" + salesperson + ", testDriveDateTime="
				+ testDriveDateTime + "]";
	}

	

	
    
    

    
}
