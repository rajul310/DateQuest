package com.app.service;

import java.util.List;
import com.app.entities.Booking;
import com.app.entities.User;

public interface IbookingService {
	
    List<Booking> getAllBookings();

    Booking addBooking(Booking transientBooking);

    String deleteBooking(Long id);

    Booking getBookingById(Long id);
    
    Booking updateBooking(Long id, Booking booking);
    
    List<Booking> getBookingsByUserId(Long userId);
    
    List<User> getUsersByBookingId(Long bookingId);
}
