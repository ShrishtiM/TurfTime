package com.app.dto;

import org.springframework.security.core.Authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SigninResponse {
	private String jwt;
	private String mesg;
	private Authentication verifiedAuth; 
}
