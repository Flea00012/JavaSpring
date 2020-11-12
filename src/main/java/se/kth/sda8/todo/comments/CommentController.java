package se.kth.sda8.todo.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

        @Autowired
        private final CommentService commentService;

        public CommentController(CommentService commentService){
                this.commentService = commentService;
        }

        //get a list of all the comment
        @GetMapping("")
        public List<Comment> getComments(@RequestParam (required = false)  String sort, @RequestParam (required = false) Long articleId){
                if (sort != null){
                        return commentService.getAll();
                }
                if(articleId != null){
                        return commentService.getById()
                }

                return commentService.getAll(sort);


        }


        //get one comment
        @GetMapping("/{id}")
        public Comment getById(@PathVariable Long id){
            return commentService.getById(id)
                    .orElseThrow(( ) -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

        //create an comment
        @PostMapping("")
        public Comment create(@RequestBody Comment newComment) {
            return commentService.create(newComment);
        }

        //update an article
        @PutMapping("")
        public Comment update(@RequestBody Comment updatedComment){
            return commentService.update(updatedComment);
        }

        //delete an article
        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id){
            commentService.delete(id);
        }




}
