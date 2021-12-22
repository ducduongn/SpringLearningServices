package com.example.rediscachedemo.service.impl;

import com.example.rediscachedemo.model.Article;
import com.example.rediscachedemo.repository.ArticleRedisRepository;
import com.example.rediscachedemo.repository.ArticleRepository;
import com.example.rediscachedemo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ducduongn
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleRedisRepository articleRedisRepository;

    private ArticleRepository articleRepository;

    @Autowired
    public void setArticleRedisRepository(ArticleRedisRepository articleRedisRepository) {
        this.articleRedisRepository = articleRedisRepository;
    }

    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findByArticleId(Long articleId) {
        Article cacheArticle = articleRedisRepository.findArticleById(articleId);

        if (cacheArticle == null) {
            Article dbArticle = articleRepository.findByArticleId(articleId);
            articleRedisRepository.saveArticle(dbArticle);
            return dbArticle;
        }
        return cacheArticle;
    }
}
