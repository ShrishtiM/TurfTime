package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.DTO.ApiResponse;
import com.app.DTO.UserDTO;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.entities.User;
import com.app.repository.UserRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Override
	public ApiResponse addNewCust(UserDTO newCust) {
		
		String encodedPassword = passwordEncoder.encode(newCust.getPassword());
		newCust.setPassword(encodedPassword);
		User user=mapper.map(newCust, User.class);
		userRepo.save(user);
		return new ApiResponse("SignUp Successful");
	}
	@Override
	public ApiResponse updateCust(String email, UserDTO dto) {
		
		String msg="Updation failed!!";
		
		User user=userRepo.findByEmail(email).orElseThrow(
				()-> new ResourceNotFoundException("Invalid id,record does not exist"));
		
		User updatedUser=mapper.map(dto, User.class);
		user.setName(updatedUser.getName());
		user.setEmail(updatedUser.getPassword());
		user.setPassword(updatedUser.getPassword());
		user.setPhoneNo(updatedUser.getPhoneNo());
		msg="Details updated successfully";
		
		return new ApiResponse(msg);
	}
	@Override
	public ApiResponse deleteCust(String email) {
		userRepo.delete(userRepo.findByEmail(email).orElseThrow(
				()-> new ResourceNotFoundException("Invalid id,failed to delete")));
		
		return new ApiResponse("Deletion sucessful");
	}

}
