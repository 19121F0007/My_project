package com.carbooking.booking.entity.userclass;

import java.util.Arrays;

import jakarta.validation.constraints.NotBlank;

public class Features {
	
	@NotBlank(message = "Air conditioning field cannot be blank")
	private String airConditioning;
	
	@NotBlank(message = "Power windows field cannot be blank")
	private String powerWindows;

	@NotBlank(message = "Power steering field cannot be blank")
	private String powerSteering;

	@NotBlank(message = "Infotainment system field cannot be blank")
	private String infotainmentSystem;
	
	@NotBlank(message = "safetyFeatures must not be empty")
    private String[] safetyFeatures;

	public String getAirConditioning() {
		return airConditioning;
	}

	public void setAirConditioning(String airConditioning) {
		this.airConditioning = airConditioning;
	}

	public String getPowerWindows() {
		return powerWindows;
	}

	public void setPowerWindows(String powerWindows) {
		this.powerWindows = powerWindows;
	}

	public String getPowerSteering() {
		return powerSteering;
	}

	public void setPowerSteering(String powerSteering) {
		this.powerSteering = powerSteering;
	}

	public String getInfotainmentSystem() {
		return infotainmentSystem;
	}

	public void setInfotainmentSystem(String infotainmentSystem) {
		this.infotainmentSystem = infotainmentSystem;
	}

	public String[] getSafetyFeatures() {
		return safetyFeatures;
	}

	public void setSafetyFeatures(String[] safetyFeatures) {
		this.safetyFeatures = safetyFeatures;
	}

	public Features(@NotBlank(message = "Air conditioning field cannot be blank") String airConditioning,
			@NotBlank(message = "Power windows field cannot be blank") String powerWindows,
			@NotBlank(message = "Power steering field cannot be blank") String powerSteering,
			@NotBlank(message = "Infotainment system field cannot be blank") String infotainmentSystem,
			@NotBlank(message = "safetyFeatures must not be empty") String[] safetyFeatures) {
		super();
		this.airConditioning = airConditioning;
		this.powerWindows = powerWindows;
		this.powerSteering = powerSteering;
		this.infotainmentSystem = infotainmentSystem;
		this.safetyFeatures = safetyFeatures;
	}

	public Features() {
		super();
	}

	@Override
	public String toString() {
		return "Features [airConditioning=" + airConditioning + ", powerWindows=" + powerWindows + ", powerSteering="
				+ powerSteering + ", infotainmentSystem=" + infotainmentSystem + ", safetyFeatures="
				+ Arrays.toString(safetyFeatures) + "]";
	}
}
