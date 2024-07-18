package com.lambdacode.spring.boot.crud.domain.api.task.updateTask;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Pattern;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTaskReq {
private byte status;
@Pattern(regexp=".{1,64}$",message = "Name must be from 1 to 64 characters")
    private String name;
    private String description;
}