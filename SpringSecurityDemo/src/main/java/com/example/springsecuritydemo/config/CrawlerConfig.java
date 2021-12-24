package com.example.springsecuritydemo.config;

import com.example.springsecuritydemo.crawler.WebCrawler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ducduongn
 */
@Configuration
public class CrawlerConfig {

    @Bean
    public WebCrawler webCrawler() {
        return new WebCrawler();
    }
}
