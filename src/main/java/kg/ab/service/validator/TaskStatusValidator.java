package com.lambdacode.spring.boot.crud.service.validator;

import com.lambdacode.spring.boot.crud.commons.enums.TaskStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TaskStatusValidator implements ConstraintValidator<ValidTaskStatus, TaskStatus> {

    @Override
    public boolean isValid(TaskStatus value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value == TaskStatus.DONE || value == TaskStatus.NOT_DONE;
    }
}
