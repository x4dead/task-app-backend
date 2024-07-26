package kg.ab.service.task.impl;

import kg.ab.commons.Util;
import kg.ab.dto.BaseResponse;
import kg.ab.entity.Task;
import kg.ab.service.task.dto.TaskDTO;
import kg.ab.service.task.dto.UpdateTaskReq;
import kg.ab.commons.enums.StatusCode;
import kg.ab.entity.TaskRepository;
import kg.ab.commons.exeption.CommonException;
import kg.ab.service.task.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private Task checkTask(Long id) {
        Task task = taskRepository.findById(id).orElse(new Task());
        if (task.getId() == null) {
            throw new CommonException(BaseResponse.builder().
                    result(StatusCode.NOT_FOUND).
                    data("Task with ID " + id + " not found").build());

        }
        return task;

    }

    @Override
    public BaseResponse<String>
    addTask(TaskDTO req) {
        Task task = Util.taskDtoToEntity(req);
        taskRepository.save(task);
        return BaseResponse.<String>builder()
                .result(StatusCode.CREATED)
                .data("Task added successfully")
                .build();
    }

    @Override
    public BaseResponse<List<Task>> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return BaseResponse.<List<Task>>builder()
                .result(StatusCode.OK)
                .data(tasks)
                .build();
    }

    @Override
    public BaseResponse<Task> getTask(Long id) {
        final Task task = checkTask(id);
        return BaseResponse.<Task>builder()
                .result(StatusCode.OK)
                .data(task)
                .build();
    }

    @Override
    public BaseResponse<String> deleteTask(Long id) {
        Task task = checkTask(id);
        taskRepository.delete(task);
        return BaseResponse.<String>builder()
                .result(StatusCode.DELETED)
                .data("Task deleted successfully")
                .build();
    }

    @Override
    public BaseResponse<String> updateTask(Long id, UpdateTaskReq req) {
        Task task = checkTask(id);
        if (req.isNothingToUpdate()) throw new CommonException(BaseResponse.builder().
                result(StatusCode.BAD_REQUEST).
                data("Nothing to update").build());
        String message = (String) Util.getUpdateMessage(req, task, false);
        Task updatedTask = (Task) Util.getUpdateMessage(req, task, true);
        taskRepository.save(updatedTask);
        return BaseResponse.<String>builder()
                .result(StatusCode.UPDATED)
                .data(message)
                .build();
    }
}
