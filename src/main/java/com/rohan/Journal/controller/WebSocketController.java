package com.rohan.Journal.controller;

import com.rohan.Journal.services.KafkaProducer;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private final KafkaProducer kafkaProducer;

    public WebSocketController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @MessageMapping("/sendMessage")
    public void sendMessage(String message) {
        kafkaProducer.sendMessage(message);
    }
}
