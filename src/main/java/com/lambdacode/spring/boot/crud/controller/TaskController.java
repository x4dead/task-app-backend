package com.lambdacode.spring.boot.crud.controller;

import com.lambdacode.spring.boot.crud.entity.Task;
import com.lambdacode.spring.boot.crud.response.Response;
import com.lambdacode.spring.boot.crud.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    /**
     * add task
     */

        @PostMapping("/add")
    public ResponseEntity<Response> addTask(@RequestBody Task user) {
            return taskService.addTask(user);

    }

    /**
     * get tasks as list
     */

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    /**
     * get task by id
     */

    @GetMapping("/get")
    public Task getTask(@RequestParam Integer id) {
        return taskService.getTask(id);
    }

    /**
     * delete task
     */

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Response> deleteTask(@PathVariable Integer id) {
        return taskService.deleteTask(id);
    }

    /**
     * update description
     */

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateDescription(@PathVariable Integer id, @RequestBody String description) {
        return taskService.updateDescription(id, description);
    }

}
