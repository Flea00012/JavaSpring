package se.kth.sda8.todo.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository repository;

    public List<Article> getAll(String sort){
        return repository.findAll().stream()
                .sorted(Comparator.comparing(sort.equals("name") ? Article:: getTitle : Article:: getAuthorName))
                .collect(Collectors.toList());
    }

    public Optional<Article> getById(Long id){
        return repository.findById(id);
    }

    public Article create(Article newArticle) {
        return repository.save(newArticle);

    }

    public Article update(Article updatedArticle){
        return repository.save(updatedArticle);

    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Article> getAllByTopicsId(Long topicId) {
        return repository.findAllByTopics_id(topicId);
    }

    public List<Article> getAll() {
        return repository.findAll();
    }
}

