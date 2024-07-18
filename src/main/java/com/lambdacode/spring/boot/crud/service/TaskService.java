package com.lambdacode.spring.boot.crud.service;
import com.lambdacode.spring.boot.crud.domain.api.task.addTask.AddTaskReq;
import com.lambdacode.spring.boot.crud.domain.api.task.updateTask.UpdateTaskReq;
import com.lambdacode.spring.boot.crud.entity.Task;
import com.lambdacode.spring.boot.crud.domain.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    ResponseEntity<Response> addTask(AddTaskReq req);

    List<Task> getTasks();

    Task getTask(int id);

    ResponseEntity<Response> deleteTask(int id);

    ResponseEntity<Response> updateNameOrDescription(int id,  UpdateTaskReq req);
}
