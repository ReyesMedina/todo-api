package dev.rmpedro.app.todo.service;

import dev.rmpedro.app.todo.mapper.TaskInDTOToTask;
import dev.rmpedro.app.todo.persistence.entity.Task;
import dev.rmpedro.app.todo.persistence.entity.TaskStatus;
import dev.rmpedro.app.todo.persistence.repository.TaskRepository;
import dev.rmpedro.app.todo.service.dto.TaskDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    TaskRepository taskRepository;

    @Mock
    TaskInDTOToTask taskInDTOToTask;

    @InjectMocks
    TaskService taskService;




    @Test
    void findAll() {
        when(taskRepository.findAll()).thenReturn(Arrays.asList(DataDummy.task1));
        List<Task> tasks = taskService.findAll();
        assertFalse(tasks.isEmpty());
        assertEquals(1,tasks.size());
        assertEquals(tasks.get(0).getTitle(),"tarea1");
    }

    @Test
    void findByTaskStatus() {
        when(taskRepository.findAllByTaskStatusEquals(TaskStatus.ON_TIME))
                .thenReturn(Arrays.asList(DataDummy.task1));
        List<Task> gotTasks = taskService.findByTaskStatus(TaskStatus.ON_TIME);
        assertFalse(gotTasks.isEmpty());
        assertEquals(1,gotTasks.size());
        assertEquals(gotTasks.get(0).getTitle(),"tarea1");

    }


}