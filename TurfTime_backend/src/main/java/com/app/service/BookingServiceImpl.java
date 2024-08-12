package com.app.service;

import java.io.IOException;
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
import com.app.utilties.EmailSender;
import com.app.utilties.PdfGenerator;
@Service
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepo;
	@Autowired
	private UserEntityRepositroy userRepo;
	@Autowired
	private TurfRepository turfRepo;
	
	@Autowired
	private EmailSender emailSender;

	@Autowired
	private PdfGenerator pdfGenerator;

	public void handleBookingSuccess(Booking booking) {
	    
	    
	    try {
	        String bookingDetails = generateBookingDetails(booking);
	        byte[] pdfBytes = pdfGenerator.generateReceiptPdf(bookingDetails);
	        emailSender.sendEmail(booking.getUser().getEmail(), pdfBytes);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	private String generateBookingDetails(Booking booking) {
	    
	    return "Booking ID: " + booking.getBookId() + "\nDetails: " + "Booking Date: "+booking.getBookingDate()+ "\n"+ 
	    "Coupon (if any): "+booking.getCoupon()+ "\nTotal Booking price: " + booking.getTotalPrice()+ "\nSlot Booked:  " + booking.getSlot()+ 
	    "\nSport selected: " + booking.getSport() + "\nTurf Details: " + booking.getTurf().getName()+"\n"+ booking.getTurf().getLocation();
		
	}

	
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
		handleBookingSuccess(booking);
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
