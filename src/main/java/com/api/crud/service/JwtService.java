package com.api.crud.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
	
	String getToken(UserDetails user);

	String getUsernameFromToken(String token);

	boolean isTokenValid(String token, UserDetails userDetails);

}
