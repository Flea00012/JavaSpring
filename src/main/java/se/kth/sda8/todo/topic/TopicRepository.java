package se.kth.sda8.todo.topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository <Topic, Long> {

    List<Topic> findAllByArticles_id(Long articleId);
}
