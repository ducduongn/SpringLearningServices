package com.example.rediscachedemo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author ducduongn
 */
@Entity
@Table(name="article")
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @NotBlank
    @Column(name = "title")
    private String title;

    @Column(name = "author")
    @NotBlank
    private String author;

    public Article(Long articleId, String title, String author) {
        this.articleId = articleId;
        this.title = title;
        this.author = author;
    }

    public Article(String title, String author) {
        this.title = title;
        this.author = author;
    }

}
