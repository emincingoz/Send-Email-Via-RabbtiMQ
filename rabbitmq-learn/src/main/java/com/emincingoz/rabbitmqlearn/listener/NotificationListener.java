package com.emincingoz.rabbitmqlearn.listener;

import com.emincingoz.rabbitmqlearn.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@Service
public class NotificationListener {

    /*@RabbitListener(queues = "deneme-queue")
    public void handleMessage(String json) {
        System.out.println("Message received..");
        System.out.println(json.toString());
        System.out.println(json);
    }*/
}
