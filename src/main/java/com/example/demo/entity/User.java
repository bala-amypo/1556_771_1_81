package com.example.demo.entity;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String fullname;
    private String email;
    private String department;
    private String role;
    private String password;
    private LocalDateTime createdAt;

    public User(LocalDateTime createdAt, String department, String email, String fullname, String password, String role) {
        this.createdAt = createdAt;
        this.department = department;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    
 }
 
