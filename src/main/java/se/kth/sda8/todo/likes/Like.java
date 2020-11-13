package se.kth.sda8.todo.likes;


import se.kth.sda8.todo.articles.Article;

import javax.persistence.*;

@Entity
@Table(name = "like")
public class Like {

    @Id
    @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Article article;

    public Like() {
    }

    public Like(Long id, String name, Article article) {
        this.id = id;
        this.name = name;
        this.article = article;
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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
