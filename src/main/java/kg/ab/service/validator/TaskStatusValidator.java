package kg.ab.service.validator;

import kg.ab.commons.enums.TaskStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TaskStatusValidator implements ConstraintValidator<TaskStatusValidation, TaskStatus> {

    @Override
    public boolean isValid(TaskStatus value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value == TaskStatus.DONE || value == TaskStatus.NOT_DONE;
    }
}
