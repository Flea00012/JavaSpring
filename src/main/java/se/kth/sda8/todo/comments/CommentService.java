package se.kth.sda8.todo.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private final CommentRepository repository;

    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    public List<Comment> getAll(String sort) {

        if (sort == null){
                return repository.findAll();
        }
        return repository.findAll().stream()
                .sorted(Comparator.comparing(sort.equals("name") ? Comment::getBody : Comment::getAuthorName))
                .collect(Collectors.toList());
    }
    public List<Comment> getAll() {
        return repository.findAll();
    }


    public Optional<Comment> getById(Long id) {
        return repository.findById(id);
    }

    public Comment create(Comment newComment) {

        return repository.save(newComment);

    }

    public Comment update(Comment updatedComment) {
        return repository.save(updatedComment);

    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Comment> getAllById(Long articleId) {
        return repository.findAllByArticleId(articleId);
    }

}