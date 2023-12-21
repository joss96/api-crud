package com.api.crud.service.impl;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.api.crud.service.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServiceImpl implements JwtService {

//	@Value("${jwt.token.secret}")
	private String secret = "SDAWE3R4TWERTFEWTG3454534R2RASDF23W3452RFSAD";

	@Override
	public String getToken(UserDetails user) {
		return getToken(new HashMap<>(), user);
	}

	private String getToken(Map<String, Object> extraClaims, UserDetails user) {
		return Jwts.builder().claims(extraClaims).subject(user.getUsername())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)).signWith(getKey()).compact();
	}

	private Key getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(this.secret);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	@Override
	public String getUsernameFromToken(String token) {
		return getClaim(token, Claims::getSubject);
	}

	@Override
	public boolean isTokenValid(String token, UserDetails userDetails) {
		String username = getUsernameFromToken(token);
		return username.equals(userDetails.getUsername()) && !isTokenExpiration(token);
	}
	
	private SecretKey getSecretKey(String token) {
		return new SecretKeySpec(Decoders.BASE64.decode(secret),SignatureAlgorithm.HS256.getJcaName());
	}

	private Claims getAllClaims(String token) {
		
//		return Jwts.parser().verifyWith(getSecretKey(token)).build().parseSignedClaims(token).getPayload();
		return Jwts.parser().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
	}

	private <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
		Claims claims = getAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Date getExpiration(String token) {
		return getClaim(token, Claims::getExpiration);
	}

	private boolean isTokenExpiration(String token) {
		return getExpiration(token).before(new Date());
	}

}
