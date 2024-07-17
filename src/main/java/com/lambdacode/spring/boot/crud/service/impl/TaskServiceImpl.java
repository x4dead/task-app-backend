package com.lambdacode.spring.boot.crud.service.impl;
import com.lambdacode.spring.boot.crud.constants.Code;
import com.lambdacode.spring.boot.crud.entity.Task;
import com.lambdacode.spring.boot.crud.repository.TaskRepository;
import com.lambdacode.spring.boot.crud.response.Response;
import com.lambdacode.spring.boot.crud.response.SuccessResponse;
import com.lambdacode.spring.boot.crud.response.exeption.CommonException;
import com.lambdacode.spring.boot.crud.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    private Task  checkTask(int id){
    return taskRepository.findById(id)
            .orElseThrow(() ->CommonException.builder().code(Code.NOT_FOUND).message("Task with ID "+ id + " not found").httpStatus(HttpStatus.NOT_FOUND) .build() );
}
    /**
     * add task
     */
    @Override
    public ResponseEntity<Response> addTask(Task task) {
//int s= 1/0;
        taskRepository.save(task);
        return new ResponseEntity<>((SuccessResponse.builder().data("Task added successfully").build()), HttpStatus.CREATED);
    }

    /**
     * get tasks as list
     */
    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    /**
     * get task by id
     */

    @Override
    public Task getTask(int id) { return checkTask(id); }


    @Override
    public ResponseEntity<Response> deleteTask(int id) {
        Task task = checkTask(id);
        taskRepository.delete(task);
        return new ResponseEntity<>(( SuccessResponse.builder().data("Task deleted successfully").build()),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> updateDescription(int id, String description) {
        Task task = checkTask(id);
        task.setDescription( description);
        taskRepository.save(task);
        return new ResponseEntity<>(( SuccessResponse.builder().data("Task updated successfully").build()),HttpStatus.OK);
    }
}
