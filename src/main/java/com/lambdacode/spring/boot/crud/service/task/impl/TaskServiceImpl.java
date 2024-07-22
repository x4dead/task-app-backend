package com.lambdacode.spring.boot.crud.service.task.impl;

import com.lambdacode.spring.boot.crud.commons.enums.TaskStatus;
import com.lambdacode.spring.boot.crud.service.task.dto.UpdateTaskReq;
import com.lambdacode.spring.boot.crud.commons.enums.StatusCode;
import com.lambdacode.spring.boot.crud.entity.Task;
import com.lambdacode.spring.boot.crud.entity.TaskRepository;
import com.lambdacode.spring.boot.crud.commons.response.Response;
import com.lambdacode.spring.boot.crud.commons.response.SuccessResponse;
import com.lambdacode.spring.boot.crud.commons.response.exeption.CommonException;
import com.lambdacode.spring.boot.crud.service.task.TaskService;
import com.lambdacode.spring.boot.crud.utils.ValidationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private static final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);
    private final TaskRepository taskRepository;
    private final ValidationUtils validationUtils;

    public TaskServiceImpl(TaskRepository taskRepository, ValidationUtils validationUtils) {
        this.taskRepository = taskRepository;
        this.validationUtils = validationUtils;
    }

    private Task checkTask(int id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> CommonException.builder().code(StatusCode.NOT_FOUND).
                        message("Task with ID " + id + " not found").
                        httpStatus(HttpStatus.NOT_FOUND).build());
    }

    @Override
    public ResponseEntity<Response> addTask(Task req) {
        validationUtils.validationRequest(req);
        final Task response = taskRepository.save(req);
        log.error(response.toString());
        return new ResponseEntity<>((SuccessResponse.builder().
                data("Task added successfully").build()), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Response> getTasks() {
        final List<Task> tasks = taskRepository.findAll();
        return new ResponseEntity<>(SuccessResponse.builder().data(tasks).build(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> getTask(int id) {
        final Task task = checkTask(id);
        return new ResponseEntity<>(SuccessResponse.builder().
                data(task).build(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> deleteTask(int id) {
        Task task = checkTask(id);
        taskRepository.delete(task);
        return new ResponseEntity<>((SuccessResponse.builder().
                data("Task deleted successfully").build()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> updateTask(int id, UpdateTaskReq req) {
        Task task = checkTask(id);
        final String desc = req.getDescription();
        final String name = req.getName();
        final TaskStatus status = req.getStatus();
        if (desc == null && name == null && status == null) {
            throw CommonException.builder().
                    code(StatusCode.BAD_REQUEST).
                    message("Nothing to update").
                    httpStatus(HttpStatus.BAD_REQUEST).build();
        }
        validationUtils.validationRequest(req);
        String message = "Task ";

        if (desc != null) {
            task.setDescription(desc);
            message += "description ";
            log.info("DESCRIPTION: {}", desc);
            log.info("NAME: {}", name);
        }
        if (name != null) {
            task.setName(name);
            if (desc != null) {
                message += "and ";
            }
            message += "name ";
        }
        if (status != null) {
            task.setStatus(status);
            message += "status ";
        }

        taskRepository.save(task);
        message += "updated successfully";
        return new ResponseEntity<>((SuccessResponse.builder().data(message).build()), HttpStatus.OK);
    }
}
