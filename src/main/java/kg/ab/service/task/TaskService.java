package com.lambdacode.spring.boot.crud.service.task;
import com.lambdacode.spring.boot.crud.service.task.dto.UpdateTaskReq;
import com.lambdacode.spring.boot.crud.entity.Task;
import com.lambdacode.spring.boot.crud.commons.response.Response;
import org.springframework.http.ResponseEntity;

public interface TaskService {
    ResponseEntity<Response> addTask(Task req);

    ResponseEntity<Response> getTasks();

    ResponseEntity<Response> getTask(int id);

    ResponseEntity<Response> deleteTask(int id);

    ResponseEntity<Response> updateTask(int id,  UpdateTaskReq req);
}
