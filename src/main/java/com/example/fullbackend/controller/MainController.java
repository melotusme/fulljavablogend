package com.example.fullbackend.controller;

import com.example.fullbackend.entity.Article;
import com.example.fullbackend.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/articles")
public class MainController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public @ResponseBody
    Iterable<Article> index() {
        return articleRepository.findAll();
    }
}
