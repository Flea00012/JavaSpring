package se.kth.sda8.todo.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    //get a list of all the articles
    @GetMapping("")
    public List<Article> getAll(@RequestParam String sort){
        return articleService.getAll(sort);
    }

    //get one article
    @GetMapping("/{id}")
    public Article getById(@PathVariable Long id){
        return articleService.getById(id)
                .orElseThrow(( ) -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //create an article
    @PostMapping("")
    public Article create(@RequestBody Article newArticle) {
        return articleService.create(newArticle);
    }

    //update an article
    @PutMapping("")
    public Article update(@RequestBody Article updatedArticle){
        return articleService.update(updatedArticle);
    }

    //delete an article
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        articleService.delete(id);
    }


}
