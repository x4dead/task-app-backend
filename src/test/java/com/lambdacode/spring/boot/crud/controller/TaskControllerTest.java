package com.lambdacode.spring.boot.crud.controller;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdacode.spring.boot.crud.domain.api.task.addTask.AddTaskReq;
import com.lambdacode.spring.boot.crud.domain.api.task.updateTask.UpdateTaskReq;
import com.lambdacode.spring.boot.crud.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@ExtendWith(MockitoExtension.class)
public class TaskControllerTest {
    @Mock
    private TaskService taskService;
@InjectMocks
private TaskController taskController;

private MockMvc mockMvc;
private ObjectMapper objectMapper;
@BeforeEach
void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
    objectMapper = new ObjectMapper();
}

@Test
void addTask() throws Exception {
    AddTaskReq addTaskReq = new AddTaskReq( 1,(byte) 0,"desc","name");
    String taskJson = objectMapper.writeValueAsString(addTaskReq);
    mockMvc.perform(post("/task/add").
            contentType(MediaType.APPLICATION_JSON).
            content(taskJson)).
            andExpect(status().isOk());
    verify(taskService,times(1)).addTask(addTaskReq);
}


    @Test
    void  getTasks() throws Exception {
    mockMvc.perform(get("/task")).  andExpect(status().isOk());
    }

    @Test
    void  getTaskById() throws Exception {
        mockMvc.perform(get("/task"). param("id","1")).
                andExpect(status().isOk());

    }

    @Test
    void  deleteTask() throws Exception {
        mockMvc.perform(delete("/task/delete/{id}",1)).
                andExpect(status().isOk());

    }

    @Test
    void  updateTask() throws Exception {
    UpdateTaskReq updateTaskReq = new UpdateTaskReq((byte) 1,"task name","desc");
        String taskJson = objectMapper.writeValueAsString(updateTaskReq);
        mockMvc.perform(put("/task/update/{id}",1).  contentType(MediaType.APPLICATION_JSON).
                content(taskJson)).
                andExpect(status().isOk());

    }

}
