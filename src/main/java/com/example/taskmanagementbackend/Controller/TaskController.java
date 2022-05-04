package com.example.taskmanagementbackend.Controller;

import com.example.taskmanagementbackend.Busniess_logic.TaskService;
import com.example.taskmanagementbackend.Dto.Task;
import com.example.taskmanagementbackend.Dto.TaskRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getTasks(@RequestParam(required = false) String searchKey){
        return taskService.getTasks(searchKey);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task saveTask(@RequestBody Task taskRequestDto){
         return taskService.saveTask(taskRequestDto);
    }


    @PutMapping
    public ResponseEntity editTask(@RequestBody Task task){
       boolean isUptaded=taskService.edit(task);

       if(!isUptaded)
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task Not Found");

        return  ResponseEntity.status(HttpStatus.OK).body(task);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@PathVariable int id){
         taskService.delete(id);
    }
}
