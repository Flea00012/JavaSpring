package se.kth.sda8.todo.likes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private final LikeService likeService;

    public LikeController(LikeService likeService){
        this.likeService = likeService;
    }

    //get a list of all the likes
    @GetMapping("")
    public List<Like> getLikes(@RequestParam (required = false) Long articleId){
        if(articleId == null){
            return likeService.getAll();
        } else {
            return likeService.getAllById(articleId);
        }
    }

    //get one like
    @GetMapping("/{id}")
    public Like getById(@PathVariable Long id){
        return likeService.getById(id)
                .orElseThrow(( ) -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //create an comment
    @PostMapping("")
    public Like create(@RequestBody Like newLike) {
        return likeService.create(newLike);
    }

    //update an article
    @PutMapping("")
    public Like update(@RequestBody Like updatedLike){
        return likeService.update(updatedLike);
    }

    //delete an article
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        likeService.delete(id);
    }


}
