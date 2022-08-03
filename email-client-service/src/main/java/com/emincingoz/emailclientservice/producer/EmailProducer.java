package com.emincingoz.emailclientservice.producer;

import com.emincingoz.emailclientservice.model.Email;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailProducer {

    @Value("${sr.rabbit.routing}")
    private String routingName;

    @Value("${sr.rabbit.exchange}")
    private String exchangeName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendToQueue(Email email) throws JsonProcessingException {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(email);

        rabbitTemplate.convertAndSend(exchangeName, routingName, json);

        System.out.println("Email sent ");
    }
}
