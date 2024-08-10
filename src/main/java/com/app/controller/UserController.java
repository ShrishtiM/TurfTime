package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.addNewCust(newCustomer));
	
}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable String id,@RequestBody UserDTO dto)
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(service.updateCust(id,dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable String id )
	{
		return ResponseEntity.ok(service.deleteCust(id));
	}
}
