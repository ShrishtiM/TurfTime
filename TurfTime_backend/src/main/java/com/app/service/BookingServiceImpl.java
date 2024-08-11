package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.InvalidCredentialsException;
import com.app.dto.ApiResponse;
import com.app.dto.BookingDTO;
import com.app.entities.Booking;
import com.app.entities.Status;
import com.app.entities.UserEntity;
import com.app.repository.BookingRepository;
import com.app.repository.TurfRepository;
import com.app.repository.UserEntityRepositroy;
@Service
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepo;
	@Autowired
	private UserEntityRepositroy userRepo;
	@Autowired
	private TurfRepository turfRepo;
	@Override
	public ApiResponse createBooking(BookingDTO dto) {
		System.out.println(dto.getName());
		UserEntity user=userRepo.findByEmail(dto.getEmail()).orElseThrow(()->
		new InvalidCredentialsException("incorrect email"));
		Booking booking=new Booking();
		booking.setUser(user);
		booking.setTurf(turfRepo.findById(1l).get());
		booking.setBookingDate(dto.getBookingDate());
		booking.setSport(dto.getSport());
		booking.setSlot(dto.getSlot());
		booking.setTotalPrice(dto.getPrice());
		booking.setStatus(Status.CONFIRMED);
		
		bookingRepo.save(booking);
		return new ApiResponse("Booking Status confirmed ");
		
	}
	@Override
	public ApiResponse cancelBooking(Long id) {
		bookingRepo.findById(id).get().setStatus(Status.CANCELLED);
		
		return new ApiResponse("Booking Cancled successfully");
		
	}
	@Override
	public List<Booking> getCurrentCustBookings(String uid) {
		List<Booking> bookings = bookingRepo.findByUserEmail(uid);
		bookings.forEach(booking -> {
		    Hibernate.initialize(booking.getUser());
		    Hibernate.initialize(booking.getTurf());
		});
	    return bookings;
	}
	
	
	
	

}
