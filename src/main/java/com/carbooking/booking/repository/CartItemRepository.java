package com.carbooking.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carbooking.booking.entity.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>{

}
