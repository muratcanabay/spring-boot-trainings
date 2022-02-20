package com.muratcanabay.sender;

import com.muratcanabay.entity.Message;
import com.muratcanabay.producer.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class MessageSender {

    private final MessageProducer messageProducer;

    @PostConstruct
    public void sendMessage() {
        Message message = Message.builder()
                .id(1L)
                .topic("Facebook")
                .message("You have a friendship request!")
                .createdAt(new Date())
                .build();

        messageProducer.sendToQueue(message);
    }
}
