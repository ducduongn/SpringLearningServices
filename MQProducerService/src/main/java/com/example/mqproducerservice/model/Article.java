package com.example.mqproducerservice.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

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
