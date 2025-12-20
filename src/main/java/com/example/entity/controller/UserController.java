package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder encoder;

    public AuthController(AuthenticationManager authManager,
                          UserService userService,
                          JwtUtil jwtUtil,
                          PasswordEncoder encoder) {
        this.authManager = authManager;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest req) {
        User u = new User();
        u.setFullName(req.fullName);
        u.setEmail(req.email);
        u.setDepartment(req.department);
        u.setPassword(req.password);
        return userService.registerUser(u);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.email, req.password)
        );
        User user = userService.getAllUsers().stream()
                .filter(u -> u.getEmail().equals(req.email))
                .findFirst().get();
        return jwtUtil.generateTokenForUser(user);
    }
}
