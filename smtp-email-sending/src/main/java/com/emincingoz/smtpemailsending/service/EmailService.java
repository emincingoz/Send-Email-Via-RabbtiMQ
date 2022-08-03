package com.emincingoz.smtpemailsending.service;

import com.emincingoz.smtpemailsending.model.EmailDetails;

public interface EmailService {

    String sendMail(EmailDetails emailDetails);
}
