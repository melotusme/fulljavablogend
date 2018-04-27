package com.example.fullbackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "articles")
public class Article {
    // You have not specified that the ID was autogenerated by the database in your mapping.
    // Without it, JPA doesn't know that it must execute a select statement after insertion in order to get the generated ID from the database.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long Id;
    private String title;
    private String body;

    @Column(name = "createdAt")
    @CreationTimestamp
    @JsonProperty("created_at")
    private Timestamp createdAt;

    @Column(name = "updatedAt")
    @UpdateTimestamp
    @JsonProperty("updated_at")
    private Timestamp updatedAt;

    public Article() {
    }
}
