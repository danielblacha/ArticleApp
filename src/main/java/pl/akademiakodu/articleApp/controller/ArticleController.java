package pl.akademiakodu.articleApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.articleApp.model.Article;
import pl.akademiakodu.articleApp.service.ArticleService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/articles/{id}")
    public Article getArticleById(@PathVariable(value = "id") int articleId) {
        return articleService.getArticleById(articleId);
    }

    @PostMapping("/articles")
    public void addArticle(@RequestBody Article article) {
        articleService.addArticle(article);
    }
    //przy update nalerzy podać takze articleId ktore chcemy zaktualizowac
    @PutMapping("/articles")
    public void updateArticleById(@RequestBody Article article) {
        articleService.updateArticle(article);
    }

    @DeleteMapping("/articles/{id}")
    public void deleteArticleById(@PathVariable(value = "id") int articleId) {
        articleService.deleteArticle(articleId);
    }
}
