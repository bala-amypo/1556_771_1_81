package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "assets", uniqueConstraints = @UniqueConstraint(columnNames = "assetTag"))
public class  Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String assetTag;

    @Column(nullable = false)
    private String assetType;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private LocalDate purchaseDate;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User currentHolder;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Asset(String assetTag, String assetType, LocalDateTime createdAt, User currentHolder, String model, LocalDate purchaseDate, String status) {
        this.assetTag = assetTag;
        this.assetType = assetType;
        this.createdAt = createdAt;
        this.currentHolder = currentHolder;
        this.model = model;
        this.purchaseDate = purchaseDate;
        this.status = status;
    }

    @PrePersist
    protected void onCreate() {
        if (status == null) {
            status = "AVAILABLE";
        }
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    public Asset(){}

    public Long getId() {
        return id;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public String getAssetType() {
        return assetType;
    }

    public String getModel() {
        return model;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public String getStatus() {
        return status;
    }

    public User getCurrentHolder() {
        return currentHolder;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCurrentHolder(User currentHolder) {
        this.currentHolder = currentHolder;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    


}
