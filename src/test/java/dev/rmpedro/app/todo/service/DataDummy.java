package dev.rmpedro.app.todo.service;

import dev.rmpedro.app.todo.persistence.entity.Task;
import dev.rmpedro.app.todo.persistence.entity.TaskStatus;
import dev.rmpedro.app.todo.service.dto.TaskDTO;
import lombok.Data;

import java.time.LocalDateTime;



public class DataDummy {
    static LocalDateTime fecha =  LocalDateTime.of(2022,12,12,10,10);
    public static final TaskDTO taskDTO1 = new TaskDTO("tarea1","tarea1",fecha);

    public static final Task task1 = new Task("tarea1","tarea1",fecha,LocalDateTime.now(),false, TaskStatus.ON_TIME);

}
