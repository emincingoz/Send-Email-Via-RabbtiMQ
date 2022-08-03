package com.emincingoz.smtpemailsending.listener;

import com.emincingoz.smtpemailsending.model.EmailDetails;
import com.emincingoz.smtpemailsending.service.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailListener {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "deneme-queue")
    public void handleMessage(String json) throws JsonProcessingException {

        System.out.println(json);

        System.out.println("Message received..");

        ObjectMapper mapper = new ObjectMapper();
        EmailDetails email = mapper.readValue(json, EmailDetails.class);

        //emailService.sendSimpleMail(email);
        //emailService.sendMailWithAttachment(email);

        emailService.sendMail(email);
    }
}
