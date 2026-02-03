package com.example.analyticsservice.processor;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EventProcessor {

    @KafkaListener(topics = "events", groupId = "analytics_group")
    public void processEvent(String event) {
        // Logic to process the event
        System.out.println("Received event: " + event);
        // Add further processing logic here
    }
}