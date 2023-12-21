package com.api.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.crud.entity.UserEntity;
import com.api.crud.model.AuthResponse;
import com.api.crud.model.LoginRequest;
import com.api.crud.model.RegisterRequest;
import com.api.crud.model.Role;
import com.api.crud.repository.UserRepository;
import com.api.crud.service.AuthService;
import com.api.crud.service.JwtService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public AuthResponse login(LoginRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
		String token = jwtService.getToken(user);

		return AuthResponse.builder().token(token).build();
	}

	@Override
	public AuthResponse register(RegisterRequest request) {
		UserEntity user = UserEntity.builder().username(request.getUsername())
				.password(passwordEncoder.encode(request.getPassword())).firstName(request.getFirstName())
				.lastName(request.getLastName()).country(request.getCountry()).role(Role.USER).build();

		userRepository.save(user);

		return AuthResponse.builder().token(jwtService.getToken(user)).build();
	}

}
