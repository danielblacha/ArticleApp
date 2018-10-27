package pl.akademiakodu.articleApp.service;

import pl.akademiakodu.articleApp.model.Article;

import java.util.List;

public interface IArticleService {
    List<Article> getAllArticles();

    Article getArticleById(int articleId);

    boolean addArticle(Article article);

    void updateArticle(Article article);

    void deleteArticle(int articleId);
}
