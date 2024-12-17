package com.example.sqs.controller;

import com.example.sqs.delegate.SqsDelegate;
import com.example.sqs.model.Message;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sqs")
public class SqsController {

    private final SqsDelegate sqsDelegate;

    public SqsController(SqsDelegate sqsDelegate) {
        this.sqsDelegate = sqsDelegate;
    }

    @PostMapping("/send-batch")
    public String sendMessages(@RequestBody List<Message> messages) {
        messages.forEach(sqsDelegate::handleSendMessage);
        return "Inviati " + messages.size() + " messaggi alla coda SQS.";
    }
}