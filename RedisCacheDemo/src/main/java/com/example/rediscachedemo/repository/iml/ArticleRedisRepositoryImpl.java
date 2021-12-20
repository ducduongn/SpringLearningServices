package com.example.rediscachedemo.repository.iml;

import com.example.rediscachedemo.model.Article;
import com.example.rediscachedemo.repository.ArticleRedisRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author ducduongn
 */
@Repository
public class ArticleRedisRepositoryImpl implements ArticleRedisRepository {
    private final String hashReference = "Article";

    @Resource(name = "redisTemplate")
    private HashOperations<String, Long, Article> hashOperations;

    @Override
    public void saveArticle(Article article) {
        hashOperations.putIfAbsent(hashReference, article.getArticleId(), article);
    }

    @Override
    public Article findArticleById(Long id) {
       return hashOperations.get(hashReference, id);
    }

    @Override
    public void updateArticle(Article article) {
        hashOperations.put(hashReference, article.getArticleId(), article);
    }

    @Override
    public void deleteArticle(Long articleId) {
        hashOperations.delete(hashReference, articleId);
    }

    @Override
    public Map<Long, Article> getAllArticles() {
        return hashOperations.entries(hashReference);
    }
}
