package com.example.springsecuritydemo.models.articles;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author ducduongn
 */
@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;
}
