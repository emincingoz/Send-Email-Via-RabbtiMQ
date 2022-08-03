package com.emincingoz.rabbitmqlearn;

import com.emincingoz.rabbitmqlearn.producer.NotificationProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class RabbitmqLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqLearnApplication.class, args);
	}

}
