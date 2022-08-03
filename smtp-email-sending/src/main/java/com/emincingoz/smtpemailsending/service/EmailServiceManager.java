package com.emincingoz.smtpemailsending.service;

import com.emincingoz.smtpemailsending.model.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailServiceManager implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public String sendSimpleMail(EmailDetails emailDetails) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(emailDetails.getRecipient());
            simpleMailMessage.setText(emailDetails.getMessageBody());
            simpleMailMessage.setSubject(emailDetails.getSubject());

            javaMailSender.send(simpleMailMessage);
            return "Mail sent successfully...";
        } catch (Exception e) {
            return "Error while sending email...";
        }

    }

    public String sendMailWithAttachment(EmailDetails emailDetails) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper;

        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(emailDetails.getRecipient());
            mimeMessageHelper.setSubject(emailDetails.getSubject());
            mimeMessageHelper.setText(emailDetails.getMessageBody());

            FileSystemResource fileSystemResource =  new FileSystemResource(new File(emailDetails.getAttachment()));
            mimeMessageHelper.addAttachment("message.png", fileSystemResource);

            javaMailSender.send(mimeMessage);

            return "Mail Sent Successfully... MimeMessage";

        } catch (MessagingException e) {
            return "Error while sending email... MimeMessage";
        }
    }

    @Override
    public String sendMail(EmailDetails emailDetails) {
        if (emailDetails.getAttachment() == null)
            return sendSimpleMail(emailDetails);

        return sendMailWithAttachment(emailDetails);
    }
}
