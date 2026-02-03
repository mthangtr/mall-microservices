package com.example.analyticsservice.controller;

import com.example.analyticsservice.service.AnalyticsService;
import com.example.analyticsservice.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @Autowired
    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @PostMapping("/events")
    public ResponseEntity<Void> trackEvent(@RequestBody Event event) {
        analyticsService.processEvent(event);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/events/{eventId}")
    public ResponseEntity<Event> getEvent(@PathVariable String eventId) {
        Event event = analyticsService.getEventById(eventId);
        return ResponseEntity.ok(event);
    }
}