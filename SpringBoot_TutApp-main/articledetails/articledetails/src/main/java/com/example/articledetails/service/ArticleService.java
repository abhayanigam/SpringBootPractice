package com.example.articledetails.service;

import com.example.articledetails.model.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface ArticleService {
    public Article getArticle(String id);

    List<Article> getArticles();

    public void deleteArticle(String id);

    public void updateArticle(Article article);

    public String createArticle(Article article);
}
