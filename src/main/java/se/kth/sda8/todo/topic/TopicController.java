package se.kth.sda8.todo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    //get a list of all the topics
    @GetMapping("")
    public List<Topic> getAll(@RequestParam String sort){

        return topicService.getAll(sort);
    }

    @GetMapping("")
    public List<Topic> getTopics(@RequestParam(required = false) Long articleId){
        if(articleId == null){
            return topicService.getAll();
        }else{
            return topicService.getAllById(articleId);
        }
    }

    //get all topics with articleId
    @GetMapping("/{id}")
    public Topic getById(@PathVariable Long id){
        return topicService.getById(id)
                .orElseThrow(( ) -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //create a topic
    @PostMapping("")
    public Topic create(@RequestBody Topic newTopic) {
        return topicService.create(newTopic);
    }

    //update a topic
    @PutMapping("")
    public Topic update(@RequestBody Topic updatedTopic){
        return topicService.update(updatedTopic);
    }

    //delete an topic
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        topicService.delete(id);
    }


}
