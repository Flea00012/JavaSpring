package se.kth.sda8.todo.tasks;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService ;

    //get a list of all the task
    @GetMapping("")
    public List<Task> getAll(@RequestParam String sort){
        return taskService.getAll(sort);
    }

    //get a single task by id
    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id){
        return taskService.getById(id)
                .orElseThrow(( ) -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //create a task
   @PostMapping("")
   public Task create(@RequestBody Task newTask) {
        return taskService.create(newTask);
    }

    //update a task
    @PutMapping("")
    public Task update(@RequestBody Task updatedTask){return taskService.update(updatedTask);}

    //delete a tasks
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        taskService.delete(id);
    }


}
