package com.app.dto;

import com.app.entities.Slot;
import com.app.entities.Sport;

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
	
	
	private String coupon;
	private String bookingDate;
	private Slot slot;
	private Sport sport;
	private String price;
	//private Status status;

}
