package com.app.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customException.NotFoundException;
import com.app.entities.Booking;
import com.app.entities.User;
import com.app.repository.IbookingRepo;
import com.app.repository.IuserRepo;

@Service
@Transactional
public class IbookingServiceImpl implements IbookingService {
	
    @Autowired
	private  IbookingRepo bookingRepo;
    
    @Autowired
    private IuserRepo userRepo;
	
    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    @Override
    public Booking addBooking(Booking transientBooking) {
        return bookingRepo.save(transientBooking);
    }

    @Override
    public String deleteBooking(Long id) throws NotFoundException {
        if (bookingRepo.existsById(id)) {
            bookingRepo.deleteById(id);
            return "Booking with ID " + id + " deleted successfully.";
        } else {
        	throw new NotFoundException("Booking with ID " + id + " not found.");
        }
    }

    @Override
    public Booking getBookingById(Long id) throws NotFoundException {
        return bookingRepo.findById(id).orElseThrow(() -> new NotFoundException("Package with ID " + id + " not found."));
    }

    @Override
    public Booking updateBooking(Long id, Booking booking) throws NotFoundException {
        if (bookingRepo.existsById(id)) {
            booking.setId(id);
            return bookingRepo.save(booking);
        } else {
        	throw new NotFoundException("Booking with ID " + id + " not found.");
        }
    }

	@Override
	public List<Booking> getBookingsByUserId(Long userId) {
		Optional<User> user = userRepo.findById(userId);
		if (user.isPresent()) {
		    User foundUser = user.get();
            return foundUser.getBookings(); 
        }
        return Collections.emptyList();
	}

	@Override
	public List<User> getUsersByBookingId(Long bookingId) {
		Optional<Booking> booking = bookingRepo.findById(bookingId);
        if (booking.isPresent()) {
            Booking foundBooking = booking.get();
            return foundBooking.getUsers(); 
        }
        return Collections.emptyList();
	}
	

}
