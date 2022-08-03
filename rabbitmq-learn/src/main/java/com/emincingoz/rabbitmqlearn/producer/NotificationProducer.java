package com.emincingoz.rabbitmqlearn.producer;

import com.emincingoz.rabbitmqlearn.model.Notification;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {

    /*@Value("${sr.rabbit.routing}")
    private String routingName;

    @Value("${sr.rabbit.exchange}")
    private String exchangeName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() throws JsonProcessingException {
        Notification notification = new Notification();

        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setCreatedDate(new Date());
        notification.setMessage("Hello World");
        notification.setSeen(Boolean.FALSE);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(notification);

        sendToQueue(json);
    }

    public void sendToQueue(String json) throws JsonProcessingException {

        System.out.println("Notification sent ID : ");
        rabbitTemplate.convertAndSend(exchangeName, routingName, json);
        System.out.println(json);
    }*/
}
