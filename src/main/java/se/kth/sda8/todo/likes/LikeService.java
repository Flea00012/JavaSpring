package se.kth.sda8.todo.likes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    @Autowired
    private final LikeRepository repository;

    public LikeService(LikeRepository repository) {
        this.repository = repository;
    }

    public List<Like> getAll() {
        return repository.findAll();
    }

    public List<Like> getAllById(Long articleId) {
        return repository.findAllByArticleId(articleId);
    }

    public Optional<Like> getById(Long id) {
        return repository.findById(id);
    }


    public Like create(Like newLike) {
        return repository.save(newLike);
    }

    public void delete(Long id) {
       repository.deleteById(id);
    }

    public Like update(Like updatedLike) {
        return repository.save(updatedLike);
    }
}
