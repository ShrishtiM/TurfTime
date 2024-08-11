package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

	List<Booking> findByUserEmail(String email);
}
