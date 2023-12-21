package com.api.crud.service;

import com.api.crud.model.AuthResponse;
import com.api.crud.model.LoginRequest;
import com.api.crud.model.RegisterRequest;

public interface AuthService {
	
	public AuthResponse login(LoginRequest request);
	public AuthResponse register(RegisterRequest request);

}
