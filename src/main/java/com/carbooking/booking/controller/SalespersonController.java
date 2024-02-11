package com.carbooking.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carbooking.booking.service.SalespersonService;

@RestController
@RequestMapping("/salespersons")
public class SalespersonController {

    @Autowired
    private SalespersonService salespersonService;

    @GetMapping("/generate-code")
    public ResponseEntity<String> generateUniqueCode() {
        String uniqueCode = salespersonService.generateUniqueCode();
        return ResponseEntity.ok(uniqueCode);
    }
}

