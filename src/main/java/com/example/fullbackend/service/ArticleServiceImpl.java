package com.example.fullbackend.service;

import com.example.fullbackend.entity.Article;
import com.example.fullbackend.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl {
    @Autowired
    private ArticleRepository articleRepository;

    //    @Override
    public Article getArticleByTitle(String title) {
        return articleRepository.findArticleByTitle(title);
    }
}
