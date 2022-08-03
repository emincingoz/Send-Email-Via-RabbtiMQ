package com.emincingoz.smtpemailsending.controller;

import com.emincingoz.smtpemailsending.model.EmailDetails;
import com.emincingoz.smtpemailsending.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("email/send-simple-email")
    public String sendSimpleMail(@RequestBody EmailDetails emailDetails) {
        String status = emailService.sendMail(emailDetails);

        return status;
    }

    @PostMapping("email/send-email-with-attachment")
    public String sendEmailWithAttachment(@RequestBody EmailDetails emailDetails) {
        String status = emailService.sendMail(emailDetails);

        return  status;
    }
}
