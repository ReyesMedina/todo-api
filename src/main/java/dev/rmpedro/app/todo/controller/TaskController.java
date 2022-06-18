package dev.rmpedro.app.todo.controller;


import dev.rmpedro.app.todo.persistence.entity.Task;
import dev.rmpedro.app.todo.persistence.entity.TaskStatus;
import dev.rmpedro.app.todo.service.TaskService;
import dev.rmpedro.app.todo.service.dto.TaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping
    public Task createTask(@RequestBody TaskDTO taskDTO){
        return this.taskService.createTask(taskDTO);

    }

    @GetMapping
    public List<Task> findAll(){
        return this.taskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByTaskStatus(@PathVariable TaskStatus status){
        return this.taskService.findByTaskStatus(status);
    }

    @PatchMapping("/mark-as-finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id){
        this.taskService.UpdateTaskAsFinished(id);
        return ResponseEntity.noContent().build();


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        this.taskService.DeleteTask(id);
        return ResponseEntity.noContent().build();
    }


}
