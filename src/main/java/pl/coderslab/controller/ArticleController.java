package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.*;
import pl.coderslab.dao.ArticleDAO;
import pl.coderslab.model.Article;
import pl.coderslab.model.Author;
import pl.coderslab.model.Category;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleController {
    private final ArticleDAO articleDAO;
    private final AuthorDAO authorDAO;
    private final CategoryDAO categoryDAO;

    public ArticleController(ArticleDAO articleDAO, AuthorDAO authorDAO, CategoryDAO categoryDAO) {
        this.articleDAO = articleDAO;
        this.authorDAO = authorDAO;
        this.categoryDAO = categoryDAO;
    }


    @RequestMapping("/article")
    @ResponseBody
    public void hello(){
        Article article = new Article();
        article.setTitle("Brawurowa akcja strazakow");
        Author author = new Author();
        author.setFirstName("Grzegorz");
        author.setLastName("Pszczola");
        authorDAO.save(author);
        article.setAuthor(author);
        Category category = new Category();
        category.setName("Fakty");
        category.setDescription("Artykuly, wiadomosci i fakty");
        categoryDAO.save(category);
        List<Category> list = new ArrayList<>();
        list.add(category);
        article.setCategoryList(list);
        articleDAO.save(article);
    }
    @RequestMapping("/article/get/{id}")
    @ResponseBody
    public String getArticle(@PathVariable long id) {
        Article article = articleDAO.findById(id);
        return article.toString();
    }

    @RequestMapping("/article/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title ) {
        Article article = articleDAO.findById(id);
        article.setTitle(title);
        articleDAO.update(article);
        return article.toString();
    }

    @RequestMapping("/article/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Article article  = articleDAO.findById(id);
        articleDAO.delete(article);
        return "deleted";
    }

}
