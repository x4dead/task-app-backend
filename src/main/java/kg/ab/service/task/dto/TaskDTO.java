package kg.ab.service.task.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import kg.ab.commons.enums.TaskStatus;
import kg.ab.service.validator.TaskStatusValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TaskDTO {
    @TaskStatusValidation
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private TaskStatus status = TaskStatus.NOT_DONE;
    private String description;
    @NotBlank(message = "Name must not be empty")
    @Pattern(regexp = ".{1,64}$", message = "Name must be from 1 to 64 characters")
    private String name;

}
