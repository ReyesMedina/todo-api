package dev.rmpedro.app.todo.persistence.repository;

import dev.rmpedro.app.todo.persistence.entity.Task;
import dev.rmpedro.app.todo.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository <Task,Long> {

    List<Task> findAllByTaskStatusEquals(TaskStatus taskStatus);

    @Modifying
    @Query(value = "UPDATE task set finished = true where id=:id",nativeQuery = true)
    void markTaskAsFinished(@Param("id") Long id);

}
