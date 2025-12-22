package com.example.demo.controller;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")   // ✅ IMPORTANT: fixes Swagger / browser CORS issue
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // ✅ Constructor injection (required)
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ✅ PUBLIC REGISTER ENDPOINT
    // POST /api/users/register
    @PostMapping("/register")
    public User registerUser(@RequestBody RegisterRequest request) {

        User user = new User();
        user.setFullName(request.fullName);
        user.setEmail(request.email);
        user.setDepartment(request.department);
        user.setPassword(request.password);

        return userService.registerUser(user);
    }

    // ✅ GET ALL USERS (protected by security)
    // GET /api/users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // ✅ GET USER BY ID (protected by security)
    // GET /api/users/{id}
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
