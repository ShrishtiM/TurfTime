package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="turf")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Turf {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long turfId;
	
	@NotEmpty(message = "Name cannot be empty")
    private String name;

	@Column(length=30)
	private String location;
	
	private Integer capacity;
	
	private Double price;
	
	private boolean availability;
	
	@Lob
	private String description;

	public Turf(String location, Integer capacity, Double price, boolean availability, String description) {
		super();
		this.location = location;
		this.capacity = capacity;
		this.price = price;
		this.availability = availability;
		this.description = description;
	}
	
	
}
