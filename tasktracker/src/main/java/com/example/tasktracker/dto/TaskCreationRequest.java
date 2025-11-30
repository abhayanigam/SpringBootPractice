package com.example.tasktracker.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskCreationRequest {
    private String description;
}