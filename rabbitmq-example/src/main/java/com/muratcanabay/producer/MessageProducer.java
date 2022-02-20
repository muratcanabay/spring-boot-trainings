package com.muratcanabay.producer;

import com.muratcanabay.entity.Message;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@RequiredArgsConstructor
public class MessageProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.name}")
    private String routingName;

    private final RabbitTemplate rabbitTemplate;

    private final Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    public void sendToQueue(Message message) {
        logger.info(
                MessageFormat
                        .format("Message ID : ${0}\n" +
                                        "Message: ${1}",
                                message.getId()), message.getMessage());
        rabbitTemplate.convertAndSend(exchangeName, routingName, message);
    }

}
