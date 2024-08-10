package com.rohan.Journal.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private final SimpMessagingTemplate template;

    public KafkaConsumer(SimpMessagingTemplate template) {
        this.template = template;
    }

    @KafkaListener(topics = "chat-messages", groupId = "group_id")
    public void listen(String message) {
        template.convertAndSend("/topic/messages", message);
    }
}
