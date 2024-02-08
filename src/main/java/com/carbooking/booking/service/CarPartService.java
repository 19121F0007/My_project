package com.carbooking.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carbooking.booking.entity.CarPart;
import com.carbooking.booking.repository.CarPartRepository;

import jakarta.validation.Valid;

@Service
public class CarPartService {

    @Autowired
    private CarPartRepository carPartRepository;

    public List<CarPart> searchCarParts(String name) {
        return carPartRepository.findByNameContainingIgnoreCase(name);
    }

    public CarPart getCarPart(Long id) {
        return carPartRepository.findById(id).orElse(null);
    }

	public CarPart addCarPart(@Valid CarPart carPart) {
		return carPartRepository.save(carPart);
	}

	public List<CarPart> getAllCarParts() {
		return carPartRepository.findAll();
	}

    public CarPart updateCarPart(CarPart carPart) {
        // Check if the car part exists
        CarPart existingCarPart = carPartRepository.findById(carPart.getId()).orElse(null);
        if (existingCarPart != null) {
            return carPartRepository.save(carPart);
        }
        return null;
    }

    public void deleteCarPart(Long id) {
        carPartRepository.deleteById(id);
    }
	
}
