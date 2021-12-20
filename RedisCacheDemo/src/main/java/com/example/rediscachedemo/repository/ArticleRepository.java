package com.example.rediscachedemo.repository;

import com.example.rediscachedemo.model.Article;
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
