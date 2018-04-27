package com.example.fullbackend.repository;

import com.example.fullbackend.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
