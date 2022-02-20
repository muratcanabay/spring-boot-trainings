package com.muratcanabay.listener;

import com.muratcanabay.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class MessageListener {

    private final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    @RabbitListener(queues = "message-queue")
    public void handleMessage(Message message) {
        logger.info(MessageFormat.format("Message recevied : ${0}", message));
    }
}
