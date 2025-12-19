// package com.example.demo.entity;

// import java.time.LocalDateTime;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.PrePersist;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "lifecycle_events")
// public class LifecycleEvent {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "asset_id")
//     private Asset asset;

//     private String eventType;
//     private String eventDescription;
//     private LocalDateTime eventDate;

//     @ManyToOne
//     @JoinColumn(name = "performed_by")
//     private User performedBy;

//     public LifecycleEvent() {
//     }

//     public LifecycleEvent(Long id, Asset asset, String eventType,
//                           String eventDescription,
//                           LocalDateTime eventDate, User performedBy) {
//         this.id = id;
//         this.asset = asset;
//         this.eventType = eventType;
//         this.eventDescription = eventDescription;
//         this.eventDate = eventDate;
//         this.performedBy = performedBy;
//     }

//     public LifecycleEvent(Asset asset, LocalDateTime eventDate, String eventDescription, String eventType, User performedBy) {
//         this.asset = asset;
//         this.eventDate = eventDate;
//         this.eventDescription = eventDescription;
//         this.eventType = eventType;
//         this.performedBy = performedBy;
//     }

//     @PrePersist
//     public void prePersist() {
//         if (eventDate == null) {
//             eventDate = LocalDateTime.now();
//         }
//     }

//     public Long getId() {
//         return id;
//     }

//     public Asset getAsset() {
//         return asset;
//     }

//     public String getEventType() {
//         return eventType;
//     }

//     public String getEventDescription() {
//         return eventDescription;
//     }

//     public LocalDateTime getEventDate() {
//         return eventDate;
//     }

//     public User getPerformedBy() {
//         return performedBy;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setAsset(Asset asset) {
//         this.asset = asset;
//     }

//     public void setEventType(String eventType) {
//         this.eventType = eventType;
//     }

//     public void setEventDescription(String eventDescription) {
//         this.eventDescription = eventDescription;
//     }

//     public void setEventDate(LocalDateTime eventDate) {
//         this.eventDate = eventDate;
//     }

//     public void setPerformedBy(User performedBy) {
//         this.performedBy = performedBy;
//     }
    
    
// }
