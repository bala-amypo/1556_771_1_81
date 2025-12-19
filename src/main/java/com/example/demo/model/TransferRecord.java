// package com.example.demo.entity;

// import java.time.LocalDate;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "transfer_records")
// public class TransferRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "asset_id")
//     private Asset asset;

//     private String fromDepartment;
//     private String toDepartment;
//     private LocalDate transferDate;

//     @ManyToOne
//     @JoinColumn(name = "approved_by")
//     private User approvedBy;

//     public TransferRecord() {
//     }

//     public TransferRecord(Long id, Asset asset,
//                           String fromDepartment, String toDepartment,
//                           LocalDate transferDate, User approvedBy) {
//         this.id = id;
//         this.asset = asset;
//         this.fromDepartment = fromDepartment;
//         this.toDepartment = toDepartment;
//         this.transferDate = transferDate;
//         this.approvedBy = approvedBy;
//     }

//     public TransferRecord(User approvedBy, Asset asset, String fromDepartment, String toDepartment, LocalDate transferDate) {
//         this.approvedBy = approvedBy;
//         this.asset = asset;
//         this.fromDepartment = fromDepartment;
//         this.toDepartment = toDepartment;
//         this.transferDate = transferDate;
//     }

//     public Long getId() {
//         return id;
//     }

//     public Asset getAsset() {
//         return asset;
//     }

//     public String getFromDepartment() {
//         return fromDepartment;
//     }

//     public String getToDepartment() {
//         return toDepartment;
//     }

//     public LocalDate getTransferDate() {
//         return transferDate;
//     }

//     public User getApprovedBy() {
//         return approvedBy;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setAsset(Asset asset) {
//         this.asset = asset;
//     }

//     public void setFromDepartment(String fromDepartment) {
//         this.fromDepartment = fromDepartment;
//     }

//     public void setToDepartment(String toDepartment) {
//         this.toDepartment = toDepartment;
//     }

//     public void setTransferDate(LocalDate transferDate) {
//         this.transferDate = transferDate;
//     }

//     public void setApprovedBy(User approvedBy) {
//         this.approvedBy = approvedBy;
//     }
    
    
// }
