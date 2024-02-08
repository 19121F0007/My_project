package com.carbooking.booking.entity.userclass;

import jakarta.validation.constraints.NotBlank;

public class AdditionalInformation {
	
	 @NotBlank(message = "VIN cannot be blank")
	 private String vin;
	 
	 private String ownerHistory;
	 
	 private String serviceHistory;
	 
	 private String additionalNotes;

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getOwnerHistory() {
		return ownerHistory;
	}

	public void setOwnerHistory(String ownerHistory) {
		this.ownerHistory = ownerHistory;
	}

	public String getServiceHistory() {
		return serviceHistory;
	}

	public void setServiceHistory(String serviceHistory) {
		this.serviceHistory = serviceHistory;
	}

	public String getAdditionalNotes() {
		return additionalNotes;
	}

	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}

	public AdditionalInformation(@NotBlank(message = "VIN cannot be blank") String vin, String ownerHistory,
			String serviceHistory, String additionalNotes) {
		super();
		this.vin = vin;
		this.ownerHistory = ownerHistory;
		this.serviceHistory = serviceHistory;
		this.additionalNotes = additionalNotes;
	}

	public AdditionalInformation() {
		super();
	}

	@Override
	public String toString() {
		return "AdditionalInformation [vin=" + vin + ", ownerHistory=" + ownerHistory + ", serviceHistory="
				+ serviceHistory + ", additionalNotes=" + additionalNotes + "]";
	}
}
