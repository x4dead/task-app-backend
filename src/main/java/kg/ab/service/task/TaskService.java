package kg.ab.service.task;

import kg.ab.service.task.dto.UpdateTaskReq;
import kg.ab.entity.Task;
import kg.ab.commons.response.Response;
import org.springframework.http.ResponseEntity;

public interface TaskService {
    ResponseEntity<Response> addTask(Task req);

    ResponseEntity<Response> getTasks();

    ResponseEntity<Response> getTask(int id);

    ResponseEntity<Response> deleteTask(int id);

    ResponseEntity<Response> updateTask(int id, UpdateTaskReq req);
}
