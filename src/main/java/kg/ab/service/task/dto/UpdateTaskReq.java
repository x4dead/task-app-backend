package kg.ab.service.task.dto;

import kg.ab.commons.enums.TaskStatus;
import kg.ab.service.validator.ValidTaskStatus;
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
    @ValidTaskStatus
    private TaskStatus status;
    @Pattern(regexp = ".{1,64}$", message = "Name must be from 1 to 64 characters")
    private String name;
    private String description;
}