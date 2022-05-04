package com.example.taskmanagementbackend.Busniess_logic;

import com.example.taskmanagementbackend.Dto.Task;
import com.example.taskmanagementbackend.Dto.TaskRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    List<Task> getTasks(String searchKey);

    Task saveTask(Task taskRequestDto);

    boolean edit(Task task);

    void delete(int id);
}
