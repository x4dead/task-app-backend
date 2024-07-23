package com.lambdacode.spring.boot.crud.service.validator;

import jakarta.validation.Payload;
import jakarta.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = TaskStatusValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTaskStatus {
    String message() default "Invalid task status";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
