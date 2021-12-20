package com.example.mqproducerservice.service;

import com.example.mqproducerservice.model.Article;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ducduongn
 */
@Service
public interface ArticleService {
    Article addArticle(Article article);

    List<Article> findAll();

    Article findByArticleId(Long articleId);
}
