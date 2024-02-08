package com.carbooking.booking.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
public class Registration implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	@NotBlank(message = "Username is required")
	@Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
	@Column(nullable = false, unique = true)
	private String username;
	
	@NotBlank(message = "Email is required")
	@Email(message = "Email should be valid")
	@Column(nullable = false, unique = true)
	private String email;
	
	@NotBlank(message = "Mobile number is required")
	@Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Invalid mobile number format")
	@Column(nullable = false, unique = true) 
	private String mobile;
	
	@NotBlank(message = "Address is required")
	@Size(min = 5, max = 100, message = "Address must be between 5 and 100 characters")
	@Column(nullable = false)
	private String address;
	
	@NotBlank(message = "Password is required")
	@Size(min = 6, message = "Password must be at least 6 characters")
	@Column(nullable = false)
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long id) {
		this.userId = id;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String geteMail() {
		return email;
	}
	public void seteMail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobile;
	}
	public void setMobileNumber(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Registration [userId=" + userId + ", username=" + username + ", email=" + email + ", mobile="
				+ mobile + ", address=" + address + ", password=" + password + "]";
	}
	public Registration(long userId, String username, String email, String mobile, String address,
			String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.password = password;
	}
	public Registration() {
		super();
	}
}