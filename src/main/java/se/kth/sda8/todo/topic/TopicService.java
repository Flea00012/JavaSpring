package se.kth.sda8.todo.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicService {

    @Autowired
    private TopicRepository repository;


    public List<Topic> getAll(String sort) {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(sort.equals("name") ? (Topic:: getName) : (null)))
                .collect(Collectors.toList());
    }

    // this might or might not return a topic -  so cool!!
    public Optional<Topic> getById(Long id) {
        return repository.findById(id);
    }

    public Topic create(Topic newTopic) {
        return repository.save(newTopic);
    }

    public Topic update(Topic updatedTopic) {
        return repository.save(updatedTopic);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Topic> getAllById(Long articleId) {
        return repository.findAllByArticleId(articleId);
    }

    public List<Topic> getAll() {
        return repository.findAll();
    }
}
