package pl.akademiakodu.articleApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.articleApp.dao.IArticleDAO;
import pl.akademiakodu.articleApp.model.Article;

import java.util.List;

@Service
public class ArticleService implements IArticleService {

    @Autowired
    private IArticleDAO iArticleDAO;

    @Override
    public List<Article> getAllArticles() {
        return iArticleDAO.getAllArticles();
    }

    @Override
    public Article getArticleById(int articleId) {
        return iArticleDAO.getArticleById(articleId);
    }

    @Override
    public boolean addArticle(Article article) {
        if (iArticleDAO.articleExists(article.getTitle(), article.getCategory())) {
            return false;
        } else {
            iArticleDAO.addArticle(article);
            return true;
        }

    }

    @Override
    public void updateArticle(Article article) {
        iArticleDAO.updateArticle(article);
    }

    @Override
    public void deleteArticle(int articleId) {
        iArticleDAO.deleteArticle(articleId);
    }
}
