package com.app.service;

import java.util.List;

import com.app.DTO.ApiResponse;
import com.app.DTO.BookingDTO;
import com.app.entities.Booking;

public interface BookingService {
	ApiResponse createBooking(BookingDTO dto);

	ApiResponse cancelBooking(Long id);

	List<Booking> getCurrentCustBookings(String uid);
}
