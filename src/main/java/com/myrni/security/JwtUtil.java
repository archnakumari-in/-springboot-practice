package com.myrni.security;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

	private static final String SECRET = "mySecretKeymySecretKeymySecretKey123456";

	private static final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

	public static String generateToken(String email) {

		return Jwts.builder().setSubject(email).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 86400000)).signWith(KEY).compact();
	}

	public static String extractUsername(String token) {

		return Jwts.parserBuilder().setSigningKey(KEY).build().parseClaimsJws(token).getBody().getSubject();
	}
}