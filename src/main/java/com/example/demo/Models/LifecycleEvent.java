package com.example.demo.entity;

import java.time.LocalDateTime;

public class LifecyckeEvent {
    private Long id;
    private Asset asset;
    private String eventType;
    private String eventDescription;
    private LocalDateTime eventDate;
    private User performedBy;

    public LifecyckeEvent(Asset asset, LocalDateTime eventDate, String eventDescription, String eventType, User performedBy) {
        this.asset = asset;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.eventType = eventType;
        this.performedBy = performedBy;
    }

    public Long getId() {
        return id;
    }

    public Asset getAsset() {
        return asset;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public User getPerformedBy() {
        return performedBy;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public void setPerformedBy(User performedBy) {
        this.performedBy = performedBy;
    }


    
}
