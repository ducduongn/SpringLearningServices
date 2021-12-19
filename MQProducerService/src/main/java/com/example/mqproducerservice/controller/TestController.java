package com.example.mqproducerservice.controller;

import com.example.mqproducerservice.model.Article;
import com.example.mqproducerservice.service.MQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ducduongn
 */
@RestController
@RequestMapping("/api/MQ/test")
public class TestController {
    private MQSender mqSender;

    @Value("${app.message}")
    private String message;

    @Autowired
    public TestController(MQSender mqSender) {
        this.mqSender = mqSender;
    }

    @PostMapping("/article")
    public String publishArticle(@RequestBody Article article) {
        mqSender.send(article);
        return message;
    }
}
