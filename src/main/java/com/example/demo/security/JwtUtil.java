package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "test-secret-key";
    private final long EXPIRATION_MS = 1000 * 60 * 60; // 1 hour

    /* ================= TOKEN GENERATION ================= */

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String generateTokenForUser(User user) {
        return generateToken(
                Map.of(
                        "role", user.getRole(),
                        "userId", user.getId()
                ),
                user.getEmail()
        );
    }

    /* ================= TOKEN VALIDATION ================= */

    public boolean isTokenValid(String token, String username) {
        String subject = parseToken(token).getSubject();
        return subject.equals(username) && !isTokenExpired(token);
    }

    /* ================= TOKEN PARSING ================= */

    public Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractRole(String token) {
        return parseToken(token).get("role", String.class);
    }

    public Long extractUserId(String token) {
        return parseToken(token).get("userId", Long.class);
    }

    private boolean isTokenExpired(String token) {
        return parseToken(token).getExpiration().before(new Date());
    }
}
