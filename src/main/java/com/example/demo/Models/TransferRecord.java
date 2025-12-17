package com.example.demo.entity;

import java.time.LocalDate;

public class TranseferRecord {
    private Long id;
    private Asset asset;
    private String fromDepartment;
    private String toDepartment;
    private LocalDate transferDate;
    private User approvedBy;

    public TranseferRecord(User approvedBy, Asset asset, String fromDepartment, String toDepartment, LocalDate transferDate) {
        this.approvedBy = approvedBy;
        this.asset = asset;
        this.fromDepartment = fromDepartment;
        this.toDepartment = toDepartment;
        this.transferDate = transferDate;
    }

    public Long getId() {
        return id;
    }

    public Asset getAsset() {
        return asset;
    }

    public String getFromDepartment() {
        return fromDepartment;
    }

    public String getToDepartment() {
        return toDepartment;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public User getApprovedBy() {
        return approvedBy;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public void setFromDepartment(String fromDepartment) {
        this.fromDepartment = fromDepartment;
    }

    public void setToDepartment(String toDepartment) {
        this.toDepartment = toDepartment;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }

    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }
   
    


}
