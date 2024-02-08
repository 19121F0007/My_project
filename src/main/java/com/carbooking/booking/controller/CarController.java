package com.carbooking.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carbooking.booking.Exception.CarNotFoundException;
import com.carbooking.booking.Exception.TestDriveBookingException;
import com.carbooking.booking.entity.Car;
import com.carbooking.booking.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@PostMapping("/add")
	public ResponseEntity<Car> addCar(@RequestBody Car car) {
	    Car savedCar = carService.addCar(car);
	    return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
	}
	
	@GetMapping("/retrieve") 
	public List<Car> retrieve(){ 
		return carService.retrieve(); 
	}
	 
	@GetMapping("/{id}")
	public ResponseEntity<Car> getCar(@PathVariable("id") Long id) {
	    Car car = carService.getCar(id);
	    if (car != null) {
	        return new ResponseEntity<>(car, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@PutMapping("/{id}")
	public ResponseEntity<Car> updateCar(@PathVariable("id") Long id, @RequestBody Car car) {
	    Car updatedCar = carService.updateCar(id, car);
	    if (updatedCar != null) {
	        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCar(@PathVariable("id") Long id) {
	    carService.deleteCar(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} 
	
	@PostMapping("/{id}/book-test-drive")
	public ResponseEntity<String> bookTestDrive(@PathVariable("id") Long id) throws CarNotFoundException, TestDriveBookingException {
		carService.bookTestDrive(id);
		return new ResponseEntity<>("Test drive booked successfully", HttpStatus.OK);
	}
	
	@PostMapping("/{id}/block-for-purchase")
	public ResponseEntity<String> blockCarForPurchase(@PathVariable("id") Long id) {
	    carService.blockCarForPurchase(id);
	    return new ResponseEntity<>("Car blocked for purchase successfully", HttpStatus.OK);
	}
}
