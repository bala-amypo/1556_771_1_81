package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Asset {
    private Long id;
    private String assetTag;
    private String assertType;
    private String model;
    private LocalDate purchaseDate;
    private String status;
    private User currentHolder;
    private LocalDateTime createdAt;

    public Asset(String assertType, String assetTag, LocalDateTime createdAt, User currentHolder, String model, LocalDate purchaseDate, String status) {
        this.assertType = assertType;
        this.assetTag = assetTag;
        this.createdAt = createdAt;
        this.currentHolder = currentHolder;
        this.model = model;
        this.purchaseDate = purchaseDate;
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public void setAssertType(String assertType) {
        this.assertType = assertType;
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

    public Long getId() {
        return id;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public String getAssertType() {
        return assertType;
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

}
