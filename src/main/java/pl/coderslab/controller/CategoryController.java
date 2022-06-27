package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.CategoryDAO;
import pl.coderslab.dao.CategoryDAO;
import pl.coderslab.model.Category;
import pl.coderslab.model.Category;

import javax.transaction.Transactional;

@Controller
public class CategoryController {
    private final CategoryDAO categoryDAO;

    public CategoryController(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }


    @RequestMapping("/category")
    @ResponseBody
    public void hello(){
        Category category = new Category();
        category.setName("Fikcja");
        category.setDescription("Super kategoria");
        categoryDAO.save(category);
    }
    @RequestMapping("/category/get/{id}")
    @ResponseBody
    public String getCategory(@PathVariable long id) {
        Category category = categoryDAO.findById(id);
        return category.toString();
    }

    @RequestMapping("/category/update/{id}/{name}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String name ) {
        Category category = categoryDAO.findById(id);
        category.setName(name);
        categoryDAO.update(category);
        return category.toString();
    }

    @RequestMapping("/category/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Category category  = categoryDAO.findById(id);
        categoryDAO.delete(category);
        return "deleted";
    }

}
