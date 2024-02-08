package com.carbooking.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.carbooking.booking.repository.RegisterRepository;

@Service
public class RegistrationService {

	@Autowired
	RegisterRepository registerRepo;
	
	public Registration register(Registration registration) throws UserAddressValidationException, UserPasswordValidationException, UserAlreadyExistsException, UserEmailValidationException, UserEmailAlreadyExistsException,UserMobileNumberAlreadyExistsException, UserMobileNumberValidationException {
		if(registerRepo.findByUsername(registration.getusername()) != null) {
			throw new UserAlreadyExistsException("user already exists");
		}
		if(!isValidEmail(registration.geteMail())) {
			throw new UserEmailValidationException("Invalid Email format");
		}
		if(!isValidMobileNumber(registration.getMobileNumber())) {
			throw new UserMobileNumberValidationException("Invalid Mobile Number format");
		}
		if(registerRepo.findByEmail(registration.geteMail()) != null) {
			throw new UserEmailAlreadyExistsException("Email already registered");
		}
		if(registerRepo.findByMobile(registration.getMobileNumber()) != null) {
			throw new UserMobileNumberAlreadyExistsException("Mobile Number already registered");
		}
		if(!isValidPassword(registration.getPassword())) {
			throw new UserPasswordValidationException("Password should be atleast 6 characters");
		}
		if(!isValidAddress(registration.getAddress())) {
			throw new UserAddressValidationException("Address must be 5 to 100 charecters");
			
		}
		return registerRepo.save(registration);
	}

	private boolean isValidAddress(String address) {
		
		return address.length() >= 5 &&  address.length() <= 100;
	}

	private boolean isValidPassword(String password) {
		return password.length() >= 6;
	}

	public List<Registration> retrieve() {
		return registerRepo.findAll();
	}

	public void authenticateUser(String username, String password) throws UserNotFoundException, IncorrectPasswordException{
		Registration registration = registerRepo.findByUsername(username);
		if(registration == null) {
			throw new UserNotFoundException("User not found");
		}
		if(!registration.getPassword().equals(password)) {
		    throw new IncorrectPasswordException("Incorrect password");
		}	
	}
	
	private boolean isValidEmail(String email) {
	    return email != null && email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
	} 
	private boolean isValidMobileNumber(String mobile) {
		return mobile != null && mobile.matches("\\d{10}$");
	}
}
