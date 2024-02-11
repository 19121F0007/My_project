package com.carbooking.booking.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carbooking.booking.Exception.BookingCancellationException;
import com.carbooking.booking.Exception.BookingNotFoundException;
import com.carbooking.booking.Exception.BookingRescheduleException;
import com.carbooking.booking.entity.Car;
import com.carbooking.booking.entity.CarPurchase;
import com.carbooking.booking.repository.CarRepository;
import com.carbooking.booking.repository.PurchaseRepository;

@Service
public class BookingService {

    @Autowired
    private PurchaseRepository purchaseRepository;
    
    @Autowired
    private CarRepository carRepository;

    public void cancelBooking(Long bookingId) throws BookingNotFoundException, BookingCancellationException {
        CarPurchase booking = purchaseRepository.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with id: " + bookingId));

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime appointmentTime = booking.getPurchaseDateTime();

        // Check if it's within the cancellation window (2 hours before appointment)
        if (now.plusHours(2).isBefore(appointmentTime)) {
            // Cancel the booking
        	Car car = new Car();
        	car.setBlockedForPurchase(false);
        	carRepository.save(car);
        	purchaseRepository.delete(booking);
        } else {
            throw new BookingCancellationException("Cannot cancel booking within 2 hours of appointment");
        }
    }

    public void rescheduleBooking(Long bookingId, LocalDateTime newAppointmentTime) throws BookingNotFoundException, BookingRescheduleException {
    	CarPurchase booking = purchaseRepository.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with id: " + bookingId));

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime appointmentTime = booking.getPurchaseDateTime();
        // Check if it's within the rescheduling window (2 hours before appointment)
        if (now.plusHours(2).isBefore(appointmentTime)) {
            // Reschedule the booking
            booking.setPurchaseDateTime(newAppointmentTime);
            purchaseRepository.save(booking);
        } else {
            throw new BookingRescheduleException("Cannot reschedule booking within 2 hours of appointment");
        }
    }
}

