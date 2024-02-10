package com.carbooking.booking.entity;

import com.carbooking.booking.entity.userclass.AdditionalInformation;
import com.carbooking.booking.entity.userclass.BasicInformation;
import com.carbooking.booking.entity.userclass.DimensionsCapacity;
import com.carbooking.booking.entity.userclass.Features;
import com.carbooking.booking.entity.userclass.PerformanceMetrics;
import com.carbooking.booking.entity.userclass.TechnicalSpecifications;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Embedded
    private BasicInformation basicInformation;
	
	@Embedded
    private TechnicalSpecifications technicalSpecifications;
	
	@Embedded
    private PerformanceMetrics performanceMetrics;
	
	@Embedded
    private DimensionsCapacity dimensionsCapacity;
	
	@Embedded
    private Features features;
	
	@Embedded
    private AdditionalInformation additionalInfo;
	
	private boolean testDriveBooked = false;
	
	private boolean blockedForPurchase = false;
	
	public Car(Long id, BasicInformation basicInformation, TechnicalSpecifications technicalSpecifications,
			PerformanceMetrics performanceMetrics, DimensionsCapacity dimensionsCapacity, Features features,
			AdditionalInformation additionalInfo, boolean testDriveBooked, boolean blockedForPurchase) {
		super();
		this.id = id;
		this.basicInformation = basicInformation;
		this.technicalSpecifications = technicalSpecifications;
		this.performanceMetrics = performanceMetrics;
		this.dimensionsCapacity = dimensionsCapacity;
		this.features = features;
		this.additionalInfo = additionalInfo;
		this.testDriveBooked = testDriveBooked;
		this.blockedForPurchase = blockedForPurchase;
	}

	public void setBlockedForPurchase(boolean blockedForPurchase) {
		this.blockedForPurchase = blockedForPurchase;
	}
    
	public Car() {
		super();
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public BasicInformation getBasicInformation() {
		return basicInformation;
	}

	public void setBasicInformation(BasicInformation basicInformation) {
		this.basicInformation = basicInformation;
	}

	public TechnicalSpecifications getTechnicalSpecifications() {
		return technicalSpecifications;
	}

	public void setTechnicalSpecifications(TechnicalSpecifications technicalSpecifications) {
		this.technicalSpecifications = technicalSpecifications;
	}

	public PerformanceMetrics getPerformanceMetrics() {
		return performanceMetrics;
	}

	public void setTestDriveBooked(boolean testDriveBooked) {
		this.testDriveBooked = testDriveBooked;
	}

	public void setPerformanceMetrics(PerformanceMetrics performanceMetrics) {
		this.performanceMetrics = performanceMetrics;
	}

	public DimensionsCapacity getDimensionsCapacity() {
		return dimensionsCapacity;
	}

	public void setDimensionsCapacity(DimensionsCapacity dimensionsCapacity) {
		this.dimensionsCapacity = dimensionsCapacity;
	}

	public Features getFeatures() {
		return features;
	}

	public void setFeatures(Features features) {
		this.features = features;
	}

	public AdditionalInformation getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(AdditionalInformation additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public boolean isTestDriveBooked() {
		return testDriveBooked;
	}

	public boolean isBlockedForPurchase() {
		return blockedForPurchase;
	}
}
