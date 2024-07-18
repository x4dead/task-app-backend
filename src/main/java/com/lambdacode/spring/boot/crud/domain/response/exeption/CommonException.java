package com.lambdacode.spring.boot.crud.domain.response.exeption;
import com.lambdacode.spring.boot.crud.domain.constants.Code;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class CommonException extends RuntimeException {
    private Code code;
    private String message;
    private HttpStatus httpStatus;

}

