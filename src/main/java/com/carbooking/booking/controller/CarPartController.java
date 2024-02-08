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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carbooking.booking.entity.CarPart;
import com.carbooking.booking.service.CarPartService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/car-parts")
public class CarPartController {

    @Autowired
    private CarPartService carPartService;

    @GetMapping("/search")
    public ResponseEntity<List<CarPart>> searchCarParts(@RequestParam("name") String name) {
        List<CarPart> carParts = carPartService.searchCarParts(name);
        return new ResponseEntity<>(carParts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarPart> getCarPart(@PathVariable("id") Long id) {
        CarPart carPart = carPartService.getCarPart(id);
        if (carPart != null) {
            return new ResponseEntity<>(carPart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Endpoint to add a new car part
    @PostMapping("/add")
    public ResponseEntity<?> addCarPart(@RequestBody CarPart carPart) {
        CarPart savedCarPart = carPartService.addCarPart(carPart);
        return new ResponseEntity<>(savedCarPart, HttpStatus.CREATED);
    }

    // Endpoint to retrieve all car parts
    @GetMapping("/retrieve")
    public ResponseEntity<List<CarPart>> getAllCarParts() {
        List<CarPart> carParts = carPartService.getAllCarParts();
        return new ResponseEntity<>(carParts, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCarPart(@PathVariable("id") Long id, @Valid @RequestBody CarPart carPart) {
        carPart.setId(id);
        CarPart updatedCarPart = carPartService.updateCarPart(carPart);
        if (updatedCarPart != null) {
            return new ResponseEntity<>(updatedCarPart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Car part not found with ID: " + id, HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete a car part by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCarPart(@PathVariable("id") Long id) {
        carPartService.deleteCarPart(id);
        return new ResponseEntity<>("Car part deleted successfully", HttpStatus.OK);
    }
    
}