package com.example.fullbackend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String title;
    private String body;

}
