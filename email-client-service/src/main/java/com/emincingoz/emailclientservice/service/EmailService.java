package com.emincingoz.emailclientservice.service;

import com.emincingoz.emailclientservice.model.Email;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface EmailService {

    String sendSimpleMail(Email email) throws JsonProcessingException;

    String sendEmailWithAttachment(Email email) throws JsonProcessingException;
}
