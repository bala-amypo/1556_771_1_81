package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
        name = "assets",
        uniqueConstraints = @UniqueConstraint(columnNames = "assetTag")
)
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String assetTag;

    private String assetType;
    private String model;
    private LocalDate purchaseDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "current_holder_id")
    private User currentHolder;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "asset")
    private List<LifecycleEvent> lifecycleEvents;

    @OneToMany(mappedBy = "asset")
    private List<TransferRecord> transferRecords;

    @OneToMany(mappedBy = "asset")
    private List<DisposalRecord> disposalRecords;

    public Asset() {}

    public Asset(Long id, String assetTag, String assetType, String model,
                 LocalDate purchaseDate, String status,
                 User currentHolder, LocalDateTime createdAt) {
        this.id = id;
        this.assetTag = assetTag;
        this.assetType = assetType;
        this.model = model;
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.currentHolder = currentHolder;
        this.createdAt = createdAt;
    }

    @PrePersist
    void prePersist() {
        if (status == null) status = "AVAILABLE";
        if (createdAt == null) createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getAssetTag() { return assetTag; }
    public void setAssetTag(String assetTag) { this.assetTag = assetTag; }
    public String getAssetType() { return assetType; }
    public void setAssetType(String assetType) { this.assetType = assetType; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public User getCurrentHolder() { return currentHolder; }
    public void setCurrentHolder(User currentHolder) { this.currentHolder = currentHolder; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
