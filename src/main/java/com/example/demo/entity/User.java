// File: src/main/java/com/example/demo/entity/User.java
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String fullName;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String department;
    
    private String role = "USER"; // ADMIN or USER
    
    @Column(nullable = false)
    private String password;
    
    private LocalDateTime createdAt;
    
    @OneToMany(mappedBy = "currentHolder")
    private List<Asset> assets = new ArrayList<>();
    
    @OneToMany(mappedBy = "performedBy")
    private List<LifecycleEvent> lifecycleEvents = new ArrayList<>();
    
    @OneToMany(mappedBy = "approvedBy")
    private List<TransferRecord> transferRecords = new ArrayList<>();
    
    @OneToMany(mappedBy = "approvedBy")
    private List<DisposalRecord> disposalRecords = new ArrayList<>();
    
    // Constructors
    public User() {}
    
    public User(Long id, String fullName, String email, String department, String role, 
                String password, LocalDateTime createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.department = department;
        this.role = role;
        this.password = password;
        this.createdAt = createdAt;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public List<Asset> getAssets() { return assets; }
    public void setAssets(List<Asset> assets) { this.assets = assets; }
    
    // PrePersist callback
    @PrePersist
    protected void onCreate() {
        if (role == null) {
            role = "USER";
        }
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}