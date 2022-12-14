package com.emincingoz.emailclientservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email implements Serializable {
    private String recipient;
    private String messageBody;
    private String subject;
    private String attachment;
}
