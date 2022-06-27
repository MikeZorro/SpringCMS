package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDAO;
import pl.coderslab.model.Author;


@Controller
public class AuthorController {
    private final AuthorDAO authorDAO;

    public AuthorController(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }


    @RequestMapping("/author")
    @ResponseBody
    public void hello(){
        Author author = new Author();
        author.setFirstName("Mike");
        author.setLastName("Magic");
        authorDAO.save(author);
    }
    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id) {
        Author author = authorDAO.findById(id);
        return author.toString();
    }

    @RequestMapping("/author/update/{id}/{lastName}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String lastName ) {
        Author author = authorDAO.findById(id);
        author.setLastName(lastName);
        authorDAO.update(author);
        return author.toString();
    }

    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Author author  = authorDAO.findById(id);
        authorDAO.delete(author);
        return "deleted";
    }


}
