package com.lambdacode.spring.boot.crud.entity;

import com.lambdacode.spring.boot.crud.commons.enums.TaskStatus;
import com.lambdacode.spring.boot.crud.service.validator.ValidTaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    @ValidTaskStatus
    private TaskStatus status;
    private String description;

    @NotBlank(message = "Name must not be empty")
    @Pattern(regexp = ".{1,64}$", message = "Name must be from 1 to 64 characters")
    private String name;

    @PrePersist
    public void prePersist() {
        if (this.status == null) {
            this.status = TaskStatus.NOT_DONE;
        }
    }
}
