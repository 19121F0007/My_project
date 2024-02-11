package com.carbooking.booking.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carbooking.booking.repository.SalespersonRepository;

@Service
public class SalespersonService {

    @Autowired
    private SalespersonRepository salespersonRepository;

    public String generateUniqueCode() {
        // Generate a unique code using UUID
        String uniqueCode = UUID.randomUUID().toString().substring(0, 8);
        
        // Check if the code is already used
        while (salespersonRepository.findByCode(uniqueCode) != null) {
            uniqueCode = UUID.randomUUID().toString().substring(0, 8);
        }

        return uniqueCode;
    }
}
