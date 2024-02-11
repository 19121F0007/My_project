package com.carbooking.booking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Salesperson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String code;
	private String name;
	private boolean available;
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Salesperson(Long id, String code, String name, boolean available) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.available = available;
	}
	public Salesperson() {
		super();
	}
	@Override
	public String toString() {
		return "Salesperson [id=" + id + ", code=" + code + ", name=" + name + ", available=" + available + "]";
	}
	
	
	
}
