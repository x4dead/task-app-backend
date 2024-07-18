package com.lambdacode.spring.boot.crud.controller;
import com.lambdacode.spring.boot.crud.domain.api.task.addTask.AddTaskReq;
import com.lambdacode.spring.boot.crud.domain.api.task.updateTask.UpdateTaskReq;
import com.lambdacode.spring.boot.crud.entity.Task;
import com.lambdacode.spring.boot.crud.domain.response.Response;
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
    public ResponseEntity<Response> addTask(@RequestBody AddTaskReq req) {
            return taskService.addTask(req);

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
    public ResponseEntity<Response> updateNameOrDescription(@PathVariable Integer id, @RequestBody UpdateTaskReq req) {
        return taskService.updateNameOrDescription(id, req);
    }

}
