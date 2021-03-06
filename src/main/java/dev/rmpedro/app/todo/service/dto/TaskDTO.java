package dev.rmpedro.app.todo.service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDTO {

    private String title;
    private String description;
    private LocalDateTime eta;


    public TaskDTO(String title, String description, LocalDateTime eta) {
        this.title = title;
        this.description=description;
        this.eta=eta;
    }
}
