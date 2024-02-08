package com.carbooking.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carbooking.booking.Exception.CarNotFoundException;
import com.carbooking.booking.Exception.CarServiceException;
import com.carbooking.booking.Exception.TestDriveBookingException;
import com.carbooking.booking.entity.Car;
import com.carbooking.booking.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	public Car addCar(Car car) {
		try {
			return carRepository.save(car);
		}catch(Exception e) {
			throw new CarServiceException("Failed to add car", e);
		}	
	}

	public List<Car> retrieve() { 
		return carRepository.findAll(); 
	}
	 
	public Car getCar(Long id) {
		try {
			return carRepository.findById(id).orElse(null);
		}catch(Exception e) {
			throw new CarServiceException("Failed to retrieve car", e);
		}  
	}

	public Car updateCar(Long id, Car car) {
	    try {
	    	Car existingCar = carRepository.findById(id).orElse(null);
		    if (existingCar != null) {
		        car.setId(id);
		        return carRepository.save(car);
		    }else {
		    	throw new CarNotFoundException("Car Not Found with id: " + id);
		    }
	    }catch(Exception e) {
	    	throw new CarServiceException("Failed to update car", e);
	    }
	}

	public void deleteCar(Long id) {
	    try {
	    	carRepository.deleteById(id);
	    }catch (Exception e) {
	    	throw new CarServiceException("Failed to delete car", e);
		}
	}

	public void bookTestDrive(Long carId) throws CarNotFoundException, TestDriveBookingException {
	    java.util.Optional<Car> optionalCar = carRepository.findById(carId);
	    if (optionalCar.isPresent()) {
	        Car car = optionalCar.get();
	        if (!car.isTestDriveBooked()) { 
	            car.setTestDriveBooked(true);
	            carRepository.save(car);
	        } else {
	            throw new TestDriveBookingException("Test drive for this car is already booked");
	        }
	    } else {
	        throw new CarNotFoundException("Car not found with id: " + carId);
	    }
	} 

	public void blockCarForPurchase(Long carid) {
		
		
	}
}
