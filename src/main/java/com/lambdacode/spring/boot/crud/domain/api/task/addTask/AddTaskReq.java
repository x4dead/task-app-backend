package com.lambdacode.spring.boot.crud.domain.api.task.addTask;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class AddTaskReq {
    @Id
    @GeneratedValue
    private int id;
    private byte status;
    private String description;
    @NotBlank(message = "Name must not be empty")
    @Pattern(regexp = ".{1,64}$",message = "Name must be from 1 to 64 characters")
    private String name;
    @PrePersist
    public void prePersist() {
        this.status = 0;
        this.description="";
    }
}
