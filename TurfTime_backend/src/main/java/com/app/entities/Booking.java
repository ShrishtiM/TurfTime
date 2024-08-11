package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Booking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "turf_id")
    private Turf turf;
    
    
    private LocalDate bookingDate;
    
    private Sport sport;
    
    @Enumerated(EnumType.STRING)
    private Slot slot;
    
    private double totalPrice;

    private String coupon;
    
    @Enumerated(EnumType.STRING)
    private Status status;

    
}
