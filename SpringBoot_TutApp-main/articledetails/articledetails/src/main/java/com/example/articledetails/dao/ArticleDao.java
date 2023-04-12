package com.example.articledetails.dao;

import com.example.articledetails.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

public interface ArticleDao extends ElasticsearchRepository<Article, String> {
}
