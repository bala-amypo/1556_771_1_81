package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour
    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // =========================
    // TOKEN GENERATION
    // =========================

    // ✅ Used by tests: generateToken(Map, String)
   public String generateToken(User user) {
    return Jwts.builder()
            .setSubject(user.getEmail())   // ✅ FIXED
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 86400000))
            .signWith(key)
            .compact();
}


    // ✅ Used by tests: generateTokenForUser(User)
    public String generateTokenForUser(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("userId", user.getId())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(secretKey)
                .compact();
    }

    // =========================
    // TOKEN PARSING
    // =========================

    // ✅ Used by tests: parseToken(String)
    public Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // =========================
    // EXTRACT DATA
    // =========================

    // ✅ Used by tests
    public String extractRole(String token) {
        return parseToken(token).get("role", String.class);
    }

    // ✅ Used by tests
    public Long extractUserId(String token) {
        return parseToken(token).get("userId", Long.class);
    }

    public String extractUsername(String token) {
        return parseToken(token).getSubject();
    }

    // =========================
    // VALIDATION
    // =========================

    // ✅ Used by tests: isTokenValid(String, String)
    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return parseToken(token).getExpiration().before(new Date());
    }
}
