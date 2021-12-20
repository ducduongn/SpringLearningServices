package com.example.mqproducerservice.repository;

import com.example.mqproducerservice.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ducduongn
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAll();

    Article findByArticleId(Long articleId);

    Boolean existsByTitle(String title);
}
