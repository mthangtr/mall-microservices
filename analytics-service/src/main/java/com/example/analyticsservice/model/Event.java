package com.example.analyticsservice.model;

import java.time.LocalDateTime;

public class Event {
    private String id;
    private String type;
    private String userId;
    private LocalDateTime timestamp;
    private String details;

    public Event() {
    }

    public Event(String id, String type, String userId, LocalDateTime timestamp, String details) {
        this.id = id;
        this.type = type;
        this.userId = userId;
        this.timestamp = timestamp;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}