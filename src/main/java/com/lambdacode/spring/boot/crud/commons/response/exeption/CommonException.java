package com.lambdacode.spring.boot.crud.commons.response.exeption;
import com.lambdacode.spring.boot.crud.commons.enums.StatusCode;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class CommonException extends RuntimeException {
    private StatusCode code;
    private String message;
    private HttpStatus httpStatus;

}

