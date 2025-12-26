package com.example.demo.security;

public class JwtUtil {

    public String generateToken(String username) {
        return "dummy-token-for-" + username;
    }

    public String extractUsername(String token) {
        if (token == null) {
            return null;
        }
        return token.replace("dummy-token-for-", "");
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("dummy-token-for-");
    }
}
