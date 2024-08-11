package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Slot;
import com.app.entities.Sport;
import com.app.entities.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookingDTO {
	
	
	private String name;
	private String email;
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long user_id;
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long turf_id;
	
	private String coupon;
	private LocalDate bookingDate;
	private Slot slot;
	private Sport sport;
	private double price;
	private Status status;

}
