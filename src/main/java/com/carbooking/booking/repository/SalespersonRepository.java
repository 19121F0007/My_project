package com.carbooking.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carbooking.booking.entity.Salesperson;

@Repository
public interface SalespersonRepository extends JpaRepository<Salesperson, Long>{

	Object findByCode(String uniqueCode);

	Salesperson findFirstByAvailable(boolean available);

}
