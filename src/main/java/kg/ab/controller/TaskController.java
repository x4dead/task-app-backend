package com.lambdacode.spring.boot.crud.controller;

import com.lambdacode.spring.boot.crud.service.task.dto.UpdateTaskReq;
import com.lambdacode.spring.boot.crud.entity.Task;
import com.lambdacode.spring.boot.crud.commons.response.Response;
import com.lambdacode.spring.boot.crud.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;


    @PostMapping()
    public ResponseEntity<Response> addTask(@RequestBody Task req) {
        return taskService.addTask(req);

    }


    @GetMapping
    public ResponseEntity<Response> getTasks() {
        return taskService.getTasks();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Response> getTask(@PathVariable Integer id) {
        return taskService.getTask(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteTask(@PathVariable Integer id) {
        return taskService.deleteTask(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Response> updateTask
            (@PathVariable Integer id, @RequestBody UpdateTaskReq req) {
        return taskService.updateTask(id, req);
    }

}
