package com.example.mqproducerservice.controller;

import com.example.mqproducerservice.model.Article;
import com.example.mqproducerservice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ducduongn
 */
@RestController
@RequestMapping("/api/article")
public class ArticleController {
    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Article>> getAllArticle() {
        List<Article> allArticles = articleService.findAll();

        return new ResponseEntity(allArticles, HttpStatus.OK);
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long articleId) {
        Article article = articleService.findByArticleId(articleId);

        return new ResponseEntity<Article>(
                article,
                HttpStatus.OK
        );
    }
}
