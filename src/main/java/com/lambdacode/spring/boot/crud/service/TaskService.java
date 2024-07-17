package com.lambdacode.spring.boot.crud.service;
import com.lambdacode.spring.boot.crud.entity.Task;
import com.lambdacode.spring.boot.crud.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    ResponseEntity<Response> addTask(Task user);

    List<Task> getTasks();

    Task getTask(int id);

    ResponseEntity<Response> deleteTask(int id);

    ResponseEntity<Response> updateDescription(int id, String description);
}
