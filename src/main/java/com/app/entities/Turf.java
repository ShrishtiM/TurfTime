package com.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="turf")
@NoArgsConstructor
@AllArgsConstructor
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
	
	private boolean availability;
	
	@Lob
	private String description;

	@OneToMany(mappedBy = "turf", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings;
	
	
	
}
