package com.app.DTO;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.app.entities.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long userId;
	
	@NotEmpty(message = "Name cannot be empty")
	private String name;
	
	@NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
	private String email;
	
	@NotEmpty(message = "Password cannot be empty")
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$\r\n"
			+ "", message="Password must be at least 8 characters long and contain an uppercase letter, a lowercase letter, a digit, and a special character.")
	@JsonProperty(access= Access.WRITE_ONLY)
	private String password;
	
	@NotEmpty(message = "Contact cannot be empty")
	private Long phoneNo;
	
	@JsonProperty(access = Access.READ_ONLY)
	private Role role= Role.CUSTOMER;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDate regDate;
}
