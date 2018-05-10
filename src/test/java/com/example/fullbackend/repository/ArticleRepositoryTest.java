package com.example.fullbackend.repository;

import com.example.fullbackend.entity.Article;
import com.example.fullbackend.repository.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ArticleRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void findById_thenReturnArticle() {
        Article article = new Article("t", "b");
        entityManager.persist(article);
        entityManager.flush();

        Article found = articleRepository.findArticleByTitle(article.getTitle());
        assert found.getBody().equals(article.getBody());
    }

    @Test
    public void contextLoads() {
    }

}
