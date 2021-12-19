package com.example.mqconsumerservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class MqConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqConsumerServiceApplication.class, args);
    }

}
