package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Article;
import pl.coderslab.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ArticleDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Article article) {
        entityManager.persist(article);
    }

    public Article findById(long id) {
        return entityManager.find(Article.class, id);
    }

    public void update(Article article) {
        entityManager.merge(article);
    }

    public void delete(Article article) {
        entityManager.remove(entityManager.contains(entityManager) ?
                article : entityManager.merge(article));
    }
}
