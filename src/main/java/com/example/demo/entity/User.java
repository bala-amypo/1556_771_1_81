package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    private String department;

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {        // ✅ REQUIRED
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {             // ✅ REQUIRED
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {       // ✅ REQUIRED
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
