package com.example.notificationservice.controller;

import com.example.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest notificationRequest) {
        notificationService.sendNotification(notificationRequest);
        return ResponseEntity.ok("Notification sent successfully");
    }

    @GetMapping("/status/{notificationId}")
    public ResponseEntity<NotificationStatus> getNotificationStatus(@PathVariable String notificationId) {
        NotificationStatus status = notificationService.getNotificationStatus(notificationId);
        return ResponseEntity.ok(status);
    }
}