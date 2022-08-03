package com.emincingoz.rabbitmqlearn.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Data
@Component
public class Notification implements Serializable {

    private String notificationId;
    private Date createdDate;
    private boolean seen;
    private String message;

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", createdDate=" + createdDate +
                ", seen=" + seen +
                ", message='" + message + '\'' +
                '}';
    }
}
