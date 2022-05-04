package com.example.taskmanagementbackend.Busniess_logic;

import com.example.taskmanagementbackend.Data_access.TaskRepository;
import com.example.taskmanagementbackend.Dto.Task;
import com.example.taskmanagementbackend.Dto.TaskRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImp  implements TaskService{
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImp(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getTasks(String searchKey) {
        return taskRepository.getTasks(searchKey);
    }

    @Override
    public Task saveTask(Task taskRequestDto) {
        return taskRepository.saveTask(taskRequestDto);
    }

    @Override
    public boolean edit(Task task) {
        return taskRepository.edit(task);
    }

    @Override
    public void delete(int id) {
         taskRepository.delete(id);
    }
}
