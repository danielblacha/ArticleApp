package pl.akademiakodu.articleApp.dao;

import org.springframework.stereotype.Repository;
import pl.akademiakodu.articleApp.model.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ArticleDAO implements IArticleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Article> getAllArticles() {
        String hgl = "FROM Article as atc1 ORDER BY atc1.articleId";
        return entityManager.createQuery(hgl).getResultList();
    }

    @Override
    public Article getArticleById(int articleId) {
        return entityManager.find(Article.class, articleId);
    }

    @Override
    public void addArticle(Article article) {
        entityManager.persist(article);
    }

    @Override
    public void updateArticle(Article article) {
        Article artc1 = getArticleById(article.getArticleId());
        artc1.setTitle(article.getTitle());
        artc1.setCategory(article.getCategory());

    }

    @Override
    public void deleteArticle(int articleId) {
        entityManager.remove(getArticleById(articleId));
    }

    @Override
    public boolean articleExists(String title, String category) {
        String hql = "FROM Article as atcl WHERE atcl.title =:title and atcl.category =:category";
        int count = entityManager.createQuery(hql).setParameter("title", title)
                .setParameter("category", category).getResultList().size();
        return count > 0 ? true : false;
    }
}
