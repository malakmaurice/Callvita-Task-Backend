package com.example.taskmanagementbackend.Data_access;

import com.example.taskmanagementbackend.Dto.Task;
import com.example.taskmanagementbackend.Dto.TaskRequestDto;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository {
    List<Task> getTasks(String searckKey);

    Task saveTask(Task taskRequestDto);

    boolean edit(Task task);

    void delete(int id);

    int findTaskIndexById(int id);

}
