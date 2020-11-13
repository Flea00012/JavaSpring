package se.kth.sda8.todo.likes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private final LikeService likeService;

    public LikeController(LikeService likeService){
        this.likeService = likeService;
    }

    //get a list of all the likes - note there is duplicity here

    @GetMapping("")
    public List<Like> getAll(){
        return likeService.getAll();
    }

    //get one like
    @GetMapping("/{id}")
    public Like getById(@PathVariable Long id){
        return likeService.getById(id);
    }

    //create a like
    @PostMapping("")
    public Like create(@RequestBody Like newLike) {
        return likeService.create(newLike);
    }

    //update a like
    @PutMapping("")
    public Like update(@RequestBody Like updatedLike){
        return likeService.update(updatedLike);
    }

    //delete a like
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        likeService.delete(id);
    }


}
