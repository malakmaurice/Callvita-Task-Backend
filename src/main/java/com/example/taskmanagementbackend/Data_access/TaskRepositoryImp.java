package com.example.taskmanagementbackend.Data_access;

import com.example.taskmanagementbackend.Dto.Task;
import com.example.taskmanagementbackend.Dto.TaskRequestDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepositoryImp  implements TaskRepository{
   List<Task> tasks=new ArrayList<>();


    @Override
    public List<Task> getTasks(String searchKey) {

        if(searchKey !=null){
            List<Task> result=new ArrayList<>();
            for(Task task :tasks){
                if(task.getName().contains(searchKey) || task.getDescription().contains(searchKey))
                    result.add(task);
            }
            return result;
        }

        return tasks;
    }



    @Override
    public Task saveTask(Task taskRequestDto) {


        Task task =new Task(taskRequestDto.getName(),taskRequestDto.getDescription());
        tasks.add(task);

        return task;
    }

    @Override
    public boolean edit(Task task) {
        int taskIndex=findTaskIndexById(task.getId());

      if(taskIndex==-1)
            return false;

        Task task1=tasks.get(taskIndex);
        task1.setName(task.getName());
     task1.setDescription(task.getDescription());

        return true;
    }

    @Override
    public void delete(int id) {
        int taskIndex=findTaskIndexById(id);
        if(taskIndex != -1)
            tasks.remove(taskIndex);
    }

    @Override
    public int findTaskIndexById(int id) {
        for(int i=0;i<tasks.size();i++){
            if(tasks.get(i).getId()==id)
                return i;
        }
        return -1;
    }
}
