package kg.ab.controller;

import jakarta.validation.Valid;
import kg.ab.dto.BaseResponse;
import kg.ab.entity.Task;
import kg.ab.service.task.dto.TaskDTO;
import kg.ab.service.task.dto.UpdateTaskReq;
import kg.ab.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping()
    public ResponseEntity<BaseResponse<String>> addTask(@Valid @RequestBody TaskDTO req) {
        var response = taskService.addTask(req);
        log.info("TaskController.addTask(): req: {}, resp: {}", req, response);
        return new ResponseEntity<>(response, response.getResult().getHttpStatus());
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<Task>>> getTasks() {
        var response = taskService.getTasks();
        log.info("TaskController.getTasks(): resp: {}", response);
        return new ResponseEntity<>(response, response.getResult().getHttpStatus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<Task>> getTask(@Valid @PathVariable Long id) {
        var response = taskService.getTask(id);
        log.info("TaskController.getTask(): taskID:{} resp: {}", id, response);
        return new ResponseEntity<>(response, response.getResult().getHttpStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<String>> deleteTask(@Valid @PathVariable Long id) {
        var response = taskService.deleteTask(id);

        log.info("TaskController.deleteTask(): taskID:{} resp: {}", id, response);
        return new ResponseEntity<>(response, response.getResult().getHttpStatus());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<String>> updateTask
            (@Valid @PathVariable Long id, @Valid @RequestBody UpdateTaskReq req) {
        var response = taskService.updateTask(id, req);
        log.info("TaskController.updateTask(): taskID:{} req: {} resp: {}", id, req, response);
        return new ResponseEntity<>(response, response.getResult().getHttpStatus());
    }

}
