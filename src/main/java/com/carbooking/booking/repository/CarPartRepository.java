package com.carbooking.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carbooking.booking.entity.CarPart;

@Repository
public interface CarPartRepository extends JpaRepository<CarPart, Long>{

	List<CarPart> findByNameContainingIgnoreCase(String name);

}
