package se.kth.sda8.todo.likes;


import se.kth.sda8.todo.articles.Article;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany (mappedBy = "likes")
    private List<Article> articles;

    public Like() {
    }

    public Like(Long id, String name) {
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
