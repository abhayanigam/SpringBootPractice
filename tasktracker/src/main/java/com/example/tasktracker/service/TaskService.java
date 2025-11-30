package com.example.tasktracker.service;

import com.example.tasktracker.entity.StatusEnum;
import com.example.tasktracker.entity.Task;
import com.example.tasktracker.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task addTask(String description) {
        Task task = new Task();

        task.setDescription(description);
        task.setStatus(StatusEnum.TODO);
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());

        return repository.save(task);
    }

    //It makes it clear to the caller: “The result might be empty.”
    public Optional<Task> updateTask(Long id , String desc){
        return repository.findById(id).map(task -> {
            task.setDescription(desc);
            task.setUpdatedAt(LocalDateTime.now());

            return repository.save(task);
        });
    }

    public boolean deleteTask(Long id){
//        if (repository.existsById(id)){
//            repository.deleteById(id);
//
//            return true;
//        }else{
//            return false;
//        }

        return repository.findById(id).map(task -> {
            repository.delete(task);
            return true;
        }).orElse(false);
    }

    public Optional<Task> markStatus(Long id, StatusEnum status){
        return repository.findById(id).map(task -> {
            task.setStatus(status);
            task.setUpdatedAt(LocalDateTime.now());

            return repository.save(task);
        });
    }

    public List<Task> listTask(){
        return repository.findAll();
    }

    public List<Task> listByStatus(StatusEnum status){
        return repository.findByStatus(status);
    }
}
