package com.example.mqconsumerservice.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author ducduongn
 */
@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class ,
        property = "@id",
        scope = Article.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Article implements Serializable {
    private Long articleId;

    private String title;

    private String author;
}
