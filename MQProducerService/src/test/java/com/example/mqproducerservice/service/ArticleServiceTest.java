package com.example.mqproducerservice.service;

import com.example.mqproducerservice.model.Article;
import com.example.mqproducerservice.repository.ArticleRepository;
import com.example.mqproducerservice.service.impl.ArticleServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;


import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author ducduongn
 */
@Import({CacheConfig.class, Article.class})
@ImportAutoConfiguration(classes = {
        CacheAutoConfiguration.class,
        RedisAutoConfiguration.class
})
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ArticleServiceTest {
    @MockBean
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleServiceImpl articleService;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Test
    void givenRedisCache_whenFindingArticleById_returnArticleFromCache() {
        Article anArticle = new Article(1L, "Duc Duong", "Elcom Diary");

        given(articleRepository.findById(1L))
                .willReturn(Optional.of(anArticle));

        Article articleCacheMiss = articleService.findByArticleId(1L);
        Article articleCacheHit = articleService.findByArticleId(1L);

        Assertions.assertEquals(articleCacheHit, anArticle);
        Assertions.assertEquals(articleCacheMiss, anArticle);

        verify(articleRepository, times(1)).findByArticleId(1L);
    }
}
