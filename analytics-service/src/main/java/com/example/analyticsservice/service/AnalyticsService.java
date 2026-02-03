package com.example.analyticsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.analyticsservice.model.Event;

@Service
public class AnalyticsService {

    @Autowired
    private EventProcessor eventProcessor;

    @KafkaListener(topics = "event-topic", groupId = "analytics-group")
    public void consumeEvent(Event event) {
        eventProcessor.process(event);
    }
    
    // Additional analytics methods can be added here
}