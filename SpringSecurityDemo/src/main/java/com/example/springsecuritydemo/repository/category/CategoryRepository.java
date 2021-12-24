package com.example.springsecuritydemo.repository.category;

import com.example.springsecuritydemo.models.articles.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ducduongn
 */
@Repository
public interface CategoryRepository extends JpaRepository<Long, Category> {
}
