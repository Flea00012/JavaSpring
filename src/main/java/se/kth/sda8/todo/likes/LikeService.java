package se.kth.sda8.todo.likes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


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

    public Like getById(Long id) {
        return repository.findById(id).orElseThrow(( ) -> new ResponseStatusException(HttpStatus.NOT_FOUND));
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
