package se.kth.sda8.todo.topic;

import se.kth.sda8.todo.articles.Article;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "topic")
public class Topic {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany (mappedBy = "topics")
    private List<Article> articles;


    public Topic() {
    }

    public Topic(Long id, String name) {
        this.id = id;
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addArticle (Article article) {
        articles.add(article);
    }


}
