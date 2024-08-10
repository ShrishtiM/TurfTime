package com.app.service;

import com.app.DTO.ApiResponse;
import com.app.DTO.UserDTO;

public interface UserService {
	ApiResponse  addNewCust(UserDTO newCust);

	ApiResponse updateCust(String email, UserDTO dto);

	ApiResponse deleteCust(String email);

}
