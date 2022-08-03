package com.emincingoz.emailclientservice.controller;

import com.emincingoz.emailclientservice.model.Email;
import com.emincingoz.emailclientservice.service.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("client/send-simple-mail")
    public String sendSimpleMail(@RequestBody Email email) throws JsonProcessingException {
        String status = emailService.sendSimpleMail(email);

        return status;
    }

    @PostMapping("client/send-mail-with-attachment")
    public String sendMailWithAttachment(@RequestBody Email email) throws JsonProcessingException {
        String status = emailService.sendEmailWithAttachment(email);

        return status;
    }
}
