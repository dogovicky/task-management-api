package com.capricon.TaskManagement_BackEnd.service;

import com.capricon.TaskManagement_BackEnd.model.Task;
import com.capricon.TaskManagement_BackEnd.repo.TasksRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    private TasksRepo repo;

    public HomeService(TasksRepo repo) {
        this.repo = repo;
    }

    public List<Task> getTasks() {
        return repo.findAll();
    }

    public void addTask(Task task) {
        repo.save(task);
    }

    public Task getTaskById(int taskId) {
        return repo.findById(taskId).orElse(null);
    }

    public Task updateTask(Task task) {
        return repo.save(task);
    }

    public void deleteTask(int taskId) {
        repo.deleteById(taskId);
    }
}
