package com.example.fullbackend.controller;

import com.example.fullbackend.entity.Article;
import com.example.fullbackend.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/api/articles")
public class MainController {
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public @ResponseBody
    Iterable<Article> index() {
        return articleRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Article find(@PathVariable(value = "id") long id) {
        return articleRepository.findById(id).get();
    }

    @PutMapping("/{id}")
    public @ResponseBody
    Article update(@PathVariable(value = "id") long id, @RequestBody Map<String, Object> payload) throws Exception {
        Article article = articleRepository.findById(id).get();
        if (payload.get("title") != null) {
            String title = payload.get("title").toString();
            article.setTitle(title);
        }
        if (payload.get("body") != null) {
            String body = payload.get("body").toString();
            article.setBody(body);
        }
        articleRepository.save(article);
        return article;
    }

    @PostMapping("/")
    public @ResponseBody
    Article create(@RequestBody Map<String, Object> payload) throws Exception {
        Article article = new Article();
        if (payload.get("title") != null) {
            String title = payload.get("title").toString();
            article.setTitle(title);
        }
        if (payload.get("body") != null) {
            String body = payload.get("body").toString();
            article.setBody(body);
        }
        article = articleRepository.save(article);
        return article;
    }
}
