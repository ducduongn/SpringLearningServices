package com.example.rediscachedemo.service;

import com.example.rediscachedemo.model.Article;
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
