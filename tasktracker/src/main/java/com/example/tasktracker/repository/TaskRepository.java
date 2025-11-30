package com.example.tasktracker.repository;

import com.example.tasktracker.entity.StatusEnum;
import com.example.tasktracker.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(StatusEnum status);
}
