package com.carbooking.booking.DTO;

import java.time.LocalDateTime;

public class TestDriveRequest {
	private Long carId;
	private LocalDateTime testDriveDateTime;
	
	public Long getCarId() {
		return carId;
	}
	public void setCarId(Long carId) {
		this.carId = carId;
	}
	public LocalDateTime getTestDriveDateTime() {
		return testDriveDateTime;
	}
	public void setTestDriveDateTime(LocalDateTime testDriveDateTime) {
		this.testDriveDateTime = testDriveDateTime;
	}

	public TestDriveRequest(Long carId, LocalDateTime testDriveDateTime) {
		super();
		this.carId = carId;
		this.testDriveDateTime = testDriveDateTime;
	}
	public TestDriveRequest() {
		super();
	}
	@Override
	public String toString() {
		return "TestDriveRequest [carId=" + carId + ", testDriveDateTime=" + testDriveDateTime + "]";
	}
}
