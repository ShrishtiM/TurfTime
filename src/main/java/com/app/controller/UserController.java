package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.UserDTO;
import com.app.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	@PostMapping
	
	public ResponseEntity<?> registerNewCustomer(@RequestBody UserDTO newCustomer){
		System.out.println("hello gtekfhdskjf");
		System.out.println("Hello ");
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.addNewCust(newCustomer));
	
}
}
