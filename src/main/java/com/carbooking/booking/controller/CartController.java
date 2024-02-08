package com.carbooking.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carbooking.booking.DTO.CartItemRequest;
import com.carbooking.booking.entity.CartItem;
import com.carbooking.booking.repository.CartItemRepository;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartItemRepository cartItemRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody CartItemRequest cartItemRequest) {
        // Validate request and add to cart
        CartItem cartItem = new CartItem();
        cartItem.setCarPart(cartItemRequest.getCarPart());
        cartItem.setQuantity(cartItemRequest.getQuantity());

        cartItemRepository.save(cartItem);

        return new ResponseEntity<>("Item added to cart", HttpStatus.OK);
       
    }
} 