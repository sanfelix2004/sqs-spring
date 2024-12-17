package com.example.sqs.delegate;

import com.example.sqs.model.Message;
import com.example.sqs.service.SqsService;
import org.springframework.stereotype.Component;

@Component
public class SqsDelegate {

    private final SqsService sqsService;

    public SqsDelegate(SqsService sqsService) {
        this.sqsService = sqsService;
    }

    public void handleSendMessage(Message message) {
        sqsService.sendMessage(message.getBody());
        System.out.println("Delegate: Messaggio inviato con successo.");
    }
}