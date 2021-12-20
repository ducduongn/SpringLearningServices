package com.example.mqproducerservice;

import com.example.mqproducerservice.model.Article;
import com.example.mqproducerservice.repository.ArticleRepository;
import com.example.mqproducerservice.service.ArticleService;
import com.example.mqproducerservice.service.impl.ArticleServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class MqProducerServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
