package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.ApiResponse;
import com.app.DTO.UserDTO;
import com.app.entities.User;
import com.app.repository.UserRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper mapper;
	@Override
	public ApiResponse addNewCust(UserDTO newCust) {
		User user=mapper.map(newCust, User.class);
		userRepo.save(user);
		return new ApiResponse("SignUp Successful");
	}

}
