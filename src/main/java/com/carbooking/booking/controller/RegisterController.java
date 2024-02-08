package com.carbooking.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carbooking.booking.DTO.UserLoginDTO;
import com.carbooking.booking.Exception.IncorrectPasswordException;
import com.carbooking.booking.Exception.UserAddressValidationException;
import com.carbooking.booking.Exception.UserAlreadyExistsException;
import com.carbooking.booking.Exception.UserEmailAlreadyExistsException;
import com.carbooking.booking.Exception.UserEmailValidationException;
import com.carbooking.booking.Exception.UserMobileNumberAlreadyExistsException;
import com.carbooking.booking.Exception.UserMobileNumberValidationException;
import com.carbooking.booking.Exception.UserNotFoundException;
import com.carbooking.booking.Exception.UserPasswordValidationException;
import com.carbooking.booking.entity.Registration;
import com.carbooking.booking.service.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegisterController {

	@Autowired
	RegistrationService registerService;
	
	@PostMapping("/add")
	public ResponseEntity<String> register(@RequestBody Registration registration) {
		try {
			registerService.register(registration);
			return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
		}catch(UserAlreadyExistsException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}catch(UserEmailValidationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}catch(UserEmailAlreadyExistsException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}catch(UserMobileNumberAlreadyExistsException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}catch(UserMobileNumberValidationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}catch(UserPasswordValidationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}catch(UserAddressValidationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("/retrieve")
	public List<Registration> retrieve(){
		return registerService.retrieve();
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserLoginDTO userLoginDTO) {
		try {
			registerService.authenticateUser(userLoginDTO.getUsername(), userLoginDTO.getPassword());
		    return ResponseEntity.ok("Login successful");
		}catch (UserNotFoundException e) {
		    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}catch (IncorrectPasswordException e) {
		    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}	   
	}
}
