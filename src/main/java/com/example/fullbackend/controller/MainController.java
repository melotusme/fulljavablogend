package com.example.fullbackend.controller;

import com.example.fullbackend.entity.Article;
import com.example.fullbackend.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public HttpEntity<Article> update(@PathVariable(value = "id") long id, @RequestBody Article articleNew) throws Exception {
        Article article = articleRepository.findById(id).get();
        if (articleNew.getTitle() != null) {
            article.setTitle(articleNew.getTitle());
        }
        if (articleNew.getBody() != null) {
            article.setBody(articleNew.getBody());
        }
        articleRepository.save(article);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    Article create(@RequestBody Article article) throws Exception {
        article = articleRepository.save(article);
        return article;
    }
}
