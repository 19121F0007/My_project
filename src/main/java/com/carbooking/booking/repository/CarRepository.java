package com.carbooking.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carbooking.booking.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

//	public Car getCar(Long id);
//	public Car updateCar(Long id, Car car);
//	void deleteCar(Long id);
}
