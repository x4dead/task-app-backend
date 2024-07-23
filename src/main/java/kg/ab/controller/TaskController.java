package kg.ab.controller;

import kg.ab.service.task.dto.UpdateTaskReq;
import kg.ab.entity.Task;
import kg.ab.commons.response.Response;
import kg.ab.service.task.TaskService;
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
