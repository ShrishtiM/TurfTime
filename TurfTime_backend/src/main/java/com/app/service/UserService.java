package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.Signup;

public interface UserService {
//sign up
	Signup userRegistration(Signup reqDTO);

	ApiResponse updateCust(String id, Signup dto);

	ApiResponse deleteCust(String id);
}
