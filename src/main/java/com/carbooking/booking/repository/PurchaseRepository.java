package com.carbooking.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carbooking.booking.entity.CarPurchase;

@Repository
public interface PurchaseRepository extends JpaRepository<CarPurchase, Long>{

}
