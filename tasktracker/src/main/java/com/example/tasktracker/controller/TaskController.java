package com.example.tasktracker.controller;

import com.example.tasktracker.dto.TaskCreationRequest;
import com.example.tasktracker.entity.StatusEnum;
import com.example.tasktracker.entity.Task;
import com.example.tasktracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/task")
public class TaskController {
    private final TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody String description){
        return ResponseEntity.ok(service.addTask(description));
    }

    /// Method 1: Send the description in the form of string only
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody String description){
//        Optional<Task> updateTask = service.updateTask(id,description);
//
//        return updateTask.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }

    /// Method 2: Send the description in the form of Json by using Entity
//    @PutMapping("update/{id}")
//    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
//        Optional<Task> updateTask = service.updateTask(id,task.getDescription());
//
//        return updateTask.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }

    /// Method 3: Send the description in the form of Json by using DTO (POJO) Request)
    @PutMapping("update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskCreationRequest request){
        Optional<Task> updateTask = service.updateTask(id,request.getDescription());

        return updateTask.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id){
        if (service.deleteTask(id)){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/inPrgress")
    public ResponseEntity<Task> markInProgress(@PathVariable Long id){
        Optional<Task> update = service.markStatus(id, StatusEnum.IN_PROGRESS);

        return update.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/done")
    public ResponseEntity<Task> markDone(@PathVariable Long id) {
        Optional<Task> updated = service.markStatus(id, StatusEnum.DONE);
        return updated.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Task> listAll() { return service.listTask(); }

    @GetMapping("/status/{status}")
    public List<Task> listByStatus(@PathVariable StatusEnum status) { return service.listByStatus(status); }

}
