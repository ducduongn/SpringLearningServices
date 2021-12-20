package com.example.rediscachedemo;

import com.example.rediscachedemo.model.Article;
import com.example.rediscachedemo.repository.ArticleRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication
public class RedisCacheDemoApplication {

    @Autowired
    private ArticleRedisRepository redisRepo;

    @PostConstruct
    public void setUpData() {
        Article article1 = Article.builder()
                .articleId(1L)
                .author("Duong Duc")
                .title("elcom diary")
                .build();

        Article article2 = Article.builder()
                .articleId(2L)
                .author("Tom")
                .title("Golden House")
                .build();

        Article article3 = Article.builder()
                .articleId(3L)
                .author("Otto")
                .title("How I lost spider man.")
                .build();

        redisRepo.saveArticle(article1);
        redisRepo.saveArticle(article2);
        redisRepo.saveArticle(article3);
    }

    @PreDestroy
    public void cleanData() {
        redisRepo.deleteArticle(1L);
        redisRepo.deleteArticle(2L);
        redisRepo.deleteArticle(3L);
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisCacheDemoApplication.class, args);
    }

}
