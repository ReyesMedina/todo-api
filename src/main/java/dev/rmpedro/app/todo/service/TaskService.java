package dev.rmpedro.app.todo.service;

import dev.rmpedro.app.todo.exceptions.TodoExceptions;
import dev.rmpedro.app.todo.mapper.TaskInDTOToTask;
import dev.rmpedro.app.todo.persistence.entity.Task;
import dev.rmpedro.app.todo.persistence.entity.TaskStatus;
import dev.rmpedro.app.todo.persistence.repository.TaskRepository;
import dev.rmpedro.app.todo.service.dto.TaskDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {


    private final TaskRepository taskRepository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository taskRepository, TaskInDTOToTask mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }


    public Task createTask(TaskDTO taskInDto){
        Task task = mapper.map(taskInDto);
        return this.taskRepository.save(task);

    }
    public List<Task> findAll(){
        return this.taskRepository.findAll();
    }

    public List<Task> findByTaskStatus(TaskStatus taskStatus){
        return this.taskRepository.findAllByTaskStatusEquals(taskStatus);
    }

    @Transactional
    public void UpdateTaskAsFinished(Long id){
        Optional<Task> taskOptional=this.taskRepository.findById(id);
        if(!taskOptional.isPresent()){
            throw new TodoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.markTaskAsFinished(id);
    }

    public void DeleteTask(Long id){
        Optional<Task> taskOptional=this.taskRepository.findById(id);
        if(!taskOptional.isPresent()){
            throw new TodoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.deleteById(id);

    }
}
