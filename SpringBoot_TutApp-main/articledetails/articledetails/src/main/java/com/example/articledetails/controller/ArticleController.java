package com.example.articledetails.controller;

import com.example.articledetails.model.Article;
import com.example.articledetails.service.ArticleService;
import org.elasticsearch.common.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(
        path = "/articles",
        produces = "application/json",
        consumes = "application/json"
)
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/{articleId}")
    public Article getArticle(@PathVariable("articleId") String articleId){
        Article var = articleService.getArticle(articleId);
        if (var == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Article with identifier %d does not exists", articleId));
        }
        return var;
    }

    @GetMapping
    public List<Article> getArticles(){
        List<Article> articles = articleService.getArticles();
        return articles;
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article){
        String id = articleService.createArticle(article);
        Article var = articleService.getArticle(id);
        if (var == null){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Student could not be created due to bad request");
        }
        return var;
    }

    @PutMapping("/{articleId}")
    public void updateArticle(@PathVariable("articleId") String articleId,@RequestBody Article article){
        article.setId(articleId);
        articleService.updateArticle(article);
    }

    @DeleteMapping("/{articleId}")
    public void deleteArticle(@PathVariable ("articleId") String articleId){
        articleService.deleteArticle(articleId);
    }
}
