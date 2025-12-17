package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DisposalRecord {
    private Long id;
    private Asset asset;
    private String disposalMethod;
    private LocalDate disposalDate;
    private User approvedBy;
    private String notes;
    private LocalDateTime createdAt;

    public DisposalRecord(User approvedBy, Asset asset, LocalDateTime createdAt, LocalDate disposalDate, String disposalMethod, String notes) {
        this.approvedBy = approvedBy;
        this.asset = asset;
        this.createdAt = createdAt;
        this.disposalDate = disposalDate;
        this.disposalMethod = disposalMethod;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public Asset getAsset() {
        return asset;
    }

    public String getDisposalMethod() {
        return disposalMethod;
    }

    public LocalDate getDisposalDate() {
        return disposalDate;
    }

    public User getApprovedBy() {
        return approvedBy;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public void setDisposalMethod(String disposalMethod) {
        this.disposalMethod = disposalMethod;
    }

    public void setDisposalDate(LocalDate disposalDate) {
        this.disposalDate = disposalDate;
    }

    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


}
