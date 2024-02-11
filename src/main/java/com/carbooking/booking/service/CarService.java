package com.carbooking.booking.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carbooking.booking.Exception.CarAlreadyBlockedException;
import com.carbooking.booking.Exception.CarNotFoundException;
import com.carbooking.booking.Exception.CarServiceException;
import com.carbooking.booking.entity.Car;
import com.carbooking.booking.entity.CarPurchase;
import com.carbooking.booking.entity.Salesperson;
import com.carbooking.booking.entity.TestDrive;
import com.carbooking.booking.repository.CarRepository;
import com.carbooking.booking.repository.PurchaseRepository;
import com.carbooking.booking.repository.SalespersonRepository;
import com.carbooking.booking.repository.TestDriveRepository;


@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
    private TestDriveRepository testDriveRepository;
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private SalespersonRepository salespersonRepository;
	
	
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
	
    public void bookTestDrive(Long carId, LocalDateTime testDriveDateTime, Salesperson salesperson) throws CarNotFoundException, CarAlreadyBlockedException {
        java.util.Optional<Car> optionalCar = carRepository.findById(carId);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            if (!car.isTestDriveBooked()) {
                car.setTestDriveBooked(true);
                carRepository.save(car);
                TestDrive testDrive = new TestDrive();
                testDrive.setCar(car);
                testDrive.setTestDriveDateTime(testDriveDateTime);
                testDrive.setSalesperson(salesperson);
                testDriveRepository.save(testDrive);
            } else {
                throw new CarAlreadyBlockedException("Car is already blocked for test drive");
            }  
        }else {
            throw new CarNotFoundException("Car not found with id: " + carId);
        }
    }

    public void blockCarForPurchase(Long carId,LocalDateTime purchaseDateTime) throws CarNotFoundException, CarAlreadyBlockedException {
        java.util.Optional<Car> optionalCar = carRepository.findById(carId);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            if (!car.isBlockedForPurchase()) {
                car.setBlockedForPurchase(true);
                carRepository.save(car);
                CarPurchase carPurchase = new CarPurchase();
                carPurchase.setCar(car);
                carPurchase.setPurchaseDateTime(purchaseDateTime);
                purchaseRepository.save(carPurchase);
            } else {
                throw new CarAlreadyBlockedException("Car is already blocked for purchase");
            }
        } else {
            throw new CarNotFoundException("Car not found with id: " + carId);
        }
    }

	public Salesperson findAvailableSalesperson() {
		// TODO Auto-generated method stub
		return salespersonRepository.findFirstByAvailable(true);
	}
    
}
