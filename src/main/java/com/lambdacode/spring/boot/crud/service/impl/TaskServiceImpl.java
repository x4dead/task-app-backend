package com.lambdacode.spring.boot.crud.service.impl;
import com.lambdacode.spring.boot.crud.domain.api.task.addTask.AddTaskReq;
import com.lambdacode.spring.boot.crud.domain.api.task.updateTask.UpdateTaskReq;
import com.lambdacode.spring.boot.crud.domain.constants.Code;
import com.lambdacode.spring.boot.crud.entity.Task;
import com.lambdacode.spring.boot.crud.repository.TaskRepository;
import com.lambdacode.spring.boot.crud.domain.response.Response;
import com.lambdacode.spring.boot.crud.domain.response.SuccessResponse;
import com.lambdacode.spring.boot.crud.domain.response.exeption.CommonException;
import com.lambdacode.spring.boot.crud.service.TaskService;
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
    private final ValidationUtils  validationUtils;

    public TaskServiceImpl(TaskRepository taskRepository, ValidationUtils validationUtils) {
        this.taskRepository = taskRepository;
        this.validationUtils = validationUtils;
    }

    private Task  checkTask(int id){
    return taskRepository.findById(id)
            .orElseThrow(() ->CommonException.builder().code(Code.NOT_FOUND).message("Task with ID "+ id + " not found").httpStatus(HttpStatus.NOT_FOUND) .build() );
}
    /**
     * add task
     */
    @Override
    public ResponseEntity<Response> addTask(AddTaskReq req) {
        validationUtils.validationRequest(req);
        final Task task = new Task().reqToTask(req);
        //        int s= 1/0;
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
    public ResponseEntity<Response> updateNameOrDescription(int id,  UpdateTaskReq req) {
        Task task = checkTask(id);
        final String desc=req.getDescription();
        final String name= req.getName();
        if(desc==null&& name==null){
            throw CommonException.builder().code(Code.BAD_REQUEST).message("Nothing to update").httpStatus(HttpStatus.BAD_REQUEST).build();
        }
        validationUtils.validationRequest(req);
         String message="Task ";

        if(desc!=null){
            task.setDescription(desc);
            message +="description ";
            log.info("DESCRIPTION: {}", desc);
            log.info("NAME: {}", name);
        }
        if(name!=null){
            task.setName(name);
            if(desc!=null){
                message +="and ";
            }
            message +="name ";
        }

        taskRepository.save(task);
        message+="updated successfully";
        return new ResponseEntity<>(( SuccessResponse.builder().data(message).build()),HttpStatus.OK);
    }
}
