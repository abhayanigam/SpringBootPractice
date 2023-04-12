package com.example.articledetails.service;

import com.example.articledetails.dao.ArticleDao;
import com.example.articledetails.model.Article;
import org.elasticsearch.common.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleDao articleDao;

    private Integer articleIncrementCounter;

    @Override
    public Article getArticle(String id) {
        Optional<Article> var = articleDao.findById(id);
        return var.get();
    }

    @Override
    public List<Article> getArticles() {
        Iterable<Article> students = articleDao.findAll();

        List<Article> result = new ArrayList<>();
        students.forEach(result::add);

        return result;
    }

    @Override
    public void deleteArticle(String id) {
        articleDao.deleteById(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleDao.save(article);
    }

    @Override
    public String createArticle(Article article) {
        Article var = articleDao.save(article);
        return article.getId();
    }
}
