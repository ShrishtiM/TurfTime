package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.BookingDTO;
import com.app.service.BookingService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	private BookingService service;
	
	@PostMapping
	public ResponseEntity<?> createNewBooking(HttpEntity<BookingDTO> httpEntity)
	{
		BookingDTO dto = httpEntity.getBody();
		System.out.println(dto.getEmail());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createBooking(dto));
	}

	@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id) {
        
        return ResponseEntity.ok(service.cancelBooking(id));
    }
	
	@GetMapping("/{uid}")
	public ResponseEntity<?> getCurrentCustBookings(@PathVariable String uid){
		return ResponseEntity.ok(service.getCurrentCustBookings(uid));
	}
}
