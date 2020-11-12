package se.kth.sda8.todo.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

        @Autowired // to get the DB repository
        private TaskRepository repository;

        private static Long idCounter =1L;

        public List<Task> getAll(String sort){
            return repository.findAll().stream()
                    .sorted(Comparator.comparing(sort.equals("name") ? Task::getName : Task::getDate))
                    .collect(Collectors.toList());
        }

        public Optional<Task> getById(Long id){
            return repository.findById(id);
        }

        public Task create(Task newTask) {
            newTask.setId(idCounter);
            idCounter++;
            return repository.save(newTask);

        }

        public Task update(Task updatedTask) {
                return repository.save(updatedTask);
        }

        public void delete(Long id) {
         repository.deleteById(id);
    }


}
