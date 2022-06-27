package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.model.Author;
import pl.coderslab.model.Category;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "article")
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String title;
    @OneToOne
    private Author author;
    @ManyToMany
    @JoinTable(name = "article_category")
    private List<Category> categoryList;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

}
