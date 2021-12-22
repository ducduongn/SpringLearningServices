package com.example.rediscachedemo.controller;

import com.example.rediscachedemo.model.Article;
import com.example.rediscachedemo.repository.ArticleRedisRepository;
import com.example.rediscachedemo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author ducduongn
 */
@RestController
@RequestMapping("/api/redis/article")
public class ArticleController {
    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllArticle() {
        List<Article> allArticles = articleService.findAll();

        return new ResponseEntity(allArticles, HttpStatus.OK);
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long articleId) {
        Article article = articleService.findByArticleId(articleId);

        if (article != null) {
            return new ResponseEntity<Article>(
                    article,
                    HttpStatus.OK
            );
        }

        return new ResponseEntity("Article not found!",HttpStatus.NOT_FOUND);
    }
}
