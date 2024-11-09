package com.capricon.TaskManagement_BackEnd.controller;


import com.capricon.TaskManagement_BackEnd.model.Task;
import com.capricon.TaskManagement_BackEnd.service.HomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class HomeController {

    private HomeService service;

    public HomeController(HomeService service) {
        this.service = service;
    }

    //fetch all tasks present and send to home page
    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks() {

        return new ResponseEntity<>(service.getTasks(), HttpStatus.OK);

    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable int taskId) {
        return new ResponseEntity<>(service.getTaskById(taskId), HttpStatus.OK);
    }

    @PostMapping("/task")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        if (task != null) {
            service.addTask(task);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/task/{taskId}")
    public ResponseEntity<String> updateTask(@PathVariable int taskId, @RequestBody Task task) {
        Task updateTask = service.getTaskById(taskId);
        if (updateTask != null) {
            service.updateTask(task);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/task/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable int taskId) {
        Task task = service.getTaskById(taskId);
        if(task != null) {
            service.deleteTask(taskId);
            return new ResponseEntity<>("Task deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }


}
