package com.carbooking.booking.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carbooking.booking.Exception.BookingCancellationException;
import com.carbooking.booking.Exception.BookingNotFoundException;
import com.carbooking.booking.Exception.BookingRescheduleException;
import com.carbooking.booking.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelBooking(@PathVariable("id") Long id) {
        try {
            bookingService.cancelBooking(id);
            return ResponseEntity.ok("Booking cancelled successfully");
        } catch (BookingNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (BookingCancellationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> rescheduleBooking(@PathVariable("id") Long id, LocalDateTime purchaseDateTime) {
        try {
            bookingService.rescheduleBooking(id, purchaseDateTime);
            return ResponseEntity.ok("Booking rescheduled successfully");
        } catch (BookingNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (BookingRescheduleException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
