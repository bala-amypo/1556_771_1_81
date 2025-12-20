package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "disposal_records")
public class DisposalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Asset asset;

    private String disposalMethod;
    private LocalDate disposalDate;

    @ManyToOne
    private User approvedBy;

    private String notes;
    private LocalDateTime createdAt;

    public DisposalRecord() {}

    @PrePersist
    void prePersist() {
        if (createdAt == null) createdAt = LocalDateTime.now();
    }

    public LocalDate getDisposalDate() { return disposalDate; }
    public User getApprovedBy() { return approvedBy; }
    public void setAsset(Asset asset) { this.asset = asset; }
    public void setApprovedBy(User approvedBy) { this.approvedBy = approvedBy; }
}
