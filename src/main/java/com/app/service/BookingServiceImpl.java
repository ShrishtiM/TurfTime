package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.ApiResponse;
import com.app.DTO.BookingDTO;
import com.app.custom_exceptions.InvalidCredentialsException;
import com.app.entities.Booking;
import com.app.entities.Status;
import com.app.entities.User;
import com.app.repository.BookingRepository;
import com.app.repository.TurfRepository;
import com.app.repository.UserRepo;
@Service
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private TurfRepository turfRepo;
	@Override
	public ApiResponse createBooking(BookingDTO dto) {
		System.out.println(dto.getName());
		User user=userRepo.findByEmail(dto.getEmail()).orElseThrow(()->
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
		return new ApiResponse("Booking Status pending..please complete payment to confirm");
		
	}
	@Override
	public ApiResponse cancelBooking(Long id) {
		bookingRepo.findById(id).get().setStatus(Status.CANCELLED);
		
		return new ApiResponse("Booking Cancled successfully");
		
	}
	@Override
	public List<Booking> getCurrentCustBookings(String uid) {
		 User user=userRepo.findByEmail(uid).get();
		 
		return bookingRepo.findByUser(user);
	}
	
	
	
	

}
