package com.emincingoz.smtpemailsending.model;

import com.emincingoz.smtpemailsending.service.EmailService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class EmailDetails {
    private String recipient;
    private String messageBody;
    private String subject;
    private String attachment;

    /*public EmailDetails(String recipient, String messageBody, String subject) {
        this.recipient = recipient;
        this.messageBody = messageBody;
        this.subject = subject;
    }*/

    @Override
    public String toString() {
        return "EmailDetails{" +
                "recipient='" + recipient + '\'' +
                ", messageBody='" + messageBody + '\'' +
                ", subject='" + subject + '\'' +
                ", attachment='" + attachment + '\'' +
                '}';
    }
}
