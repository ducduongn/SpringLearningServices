package com.example.rediscachedemo.repository;

import com.example.rediscachedemo.model.Article;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author ducduongn
 */
public interface ArticleRedisRepository {
    void saveArticle(Article article);

    Article findArticleById(Long id);

    void updateArticle(Article article);

    void deleteArticle(Long articleId);

    Map<Long, Article> getAllArticles();
}
