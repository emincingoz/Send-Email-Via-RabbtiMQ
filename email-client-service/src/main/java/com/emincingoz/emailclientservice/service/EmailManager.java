package com.emincingoz.emailclientservice.service;

import com.emincingoz.emailclientservice.model.Email;
import com.emincingoz.emailclientservice.producer.EmailProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailManager implements EmailService {

    /*@Value("${sr.rabbit.routing}")
    private String routingName;

    @Value("${sr.rabbit.exchange}")
    private String exchangeName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendToQueue(String json) {
        System.out.println("Email sent ");
        rabbitTemplate.convertAndSend(exchangeName, routingName, json);
    }*/

    @Autowired
    private EmailProducer emailProducer;

    @Override
    public String sendSimpleMail(Email email) throws JsonProcessingException {

        /*System.out.println(email);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(email);

        System.out.println(json);*/

        emailProducer.sendToQueue(email);

        return "Positive";

    }

    @Override
    public String sendEmailWithAttachment(Email email) throws JsonProcessingException {

        /*ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(email);*/

        emailProducer.sendToQueue(email);

        return "ok.";
    }
}
