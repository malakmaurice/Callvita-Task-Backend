package com.example.taskmanagementbackend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;


public class Task {
    private static AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String name;
    private String description;

    public Task() {
    }

    public Task(String name, String description){
        this.name=name;
        this.description=description;
        this.id=count.incrementAndGet();
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
