package dev.rmpedro.app.todo.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime eta;
    private boolean finished;
    private TaskStatus taskStatus;

    public Task(String title, String description, LocalDateTime createdDate, LocalDateTime eta, boolean finished, TaskStatus taskStatus) {
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.eta = eta;
        this.finished = finished;
        this.taskStatus = taskStatus;
    }

    public Task() {
    }

    public boolean isFinished() {
        return finished;
    }
}
