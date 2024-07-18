package com.lambdacode.spring.boot.crud.entity;
import com.lambdacode.spring.boot.crud.domain.api.task.addTask.AddTaskReq;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue
    private int id;
    private byte status;
    private String description;
    private String name;

    public Task reqToTask(AddTaskReq req){
        return new Task(req.getId(),req.getStatus(),req.getDescription(),req.getName());
    }
}
