package com.example.mqproducerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MqProducerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqProducerServiceApplication.class, args);
    }

}
