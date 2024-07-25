package kg.ab.controller;

import kg.ab.commons.enums.StatusCode;
import kg.ab.commons.exeption.CommonException;
import kg.ab.dto.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.PropertyNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Objects;


@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class Advice {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<BaseResponse<Object>> handleCommonException(CommonException ex) {
        log.error("CommonException: {}", ex.toString());
        return ResponseEntity.status(ex.getBaseResponse().getResult().getHttpStatus()).body(ex.getBaseResponse());

    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<BaseResponse<Object>> handleMethodArgumentTypeMismatchException
            (MethodArgumentTypeMismatchException ex) {
        log.error("MethodArgumentTypeMismatchException: {}", ex.toString());
        return ResponseEntity.badRequest().
                body(new CommonException(BaseResponse.builder().result(StatusCode.ARGUMENT_TYPE_MISMATCH).
                        data(ex).build()).getBaseResponse());
    }

    @ExceptionHandler(PropertyNotFoundException.class)
    public ResponseEntity<BaseResponse<Object>> handlePropertyNotFoundException
            (PropertyNotFoundException ex) {
        log.error("NoHandlerFoundException: {}", ex.toString());
        return ResponseEntity.badRequest().
                body(new CommonException(BaseResponse.builder().result(StatusCode.NOT_FOUND).
                        data("There is nothing here.").build()).getBaseResponse());
    }


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<BaseResponse<Object>> handleHttpRequestMethodNotSupportedException
            (HttpRequestMethodNotSupportedException ex) {
        log.error("HttpRequestMethodNotSupportedException: {}", ex.toString());
        return ResponseEntity.status(StatusCode.NOT_SUPPORTED.getHttpStatus()).
                body(new CommonException(BaseResponse.builder().result(StatusCode.NOT_SUPPORTED).
                        data(ex.getMessage()).build()).getBaseResponse());
    }


    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<BaseResponse<Object>> handleMissingRequestHeaderException(MissingRequestHeaderException ex) {
        log.error("MissingRequestHeaderException: {}", ex.toString());
        return ResponseEntity.status(StatusCode.MISSING_REQUEST_HEADER.getHttpStatus()).
                body(new CommonException(BaseResponse.builder().result(StatusCode.MISSING_REQUEST_HEADER).
                        data(ex.getMessage()).build()).getBaseResponse());
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<BaseResponse<Object>> handleMissingPathVariableException(MissingPathVariableException ex) {
        log.error("MissingPathVariableException: {}", ex.toString());
        return ResponseEntity.badRequest().
                body(new CommonException(BaseResponse.builder().
                        result(StatusCode.MISSING_PATH_VARIABLE).
                        data(ex.getMessage()).build()).getBaseResponse());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<Object>> handleUnexpectedErrorException(Exception ex) {
        log.error("Exception: {}", ex.toString());

        return ResponseEntity.internalServerError().
                body(new CommonException(BaseResponse.builder().
                        result(StatusCode.INTERNAL_SERVER_ERROR).
                        data("Внутренняя ошибка сервиса").build()).getBaseResponse());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<Object>> handleMethodArgumentNotValidException
            (MethodArgumentNotValidException ex) {
        log.error("MethodArgumentNotValidException: {}", ex.toString());
        return ResponseEntity.badRequest().
                body(new CommonException(BaseResponse.builder().
                        result(StatusCode.REQUEST_VALIDATION_ERROR).
                        data(Objects.requireNonNull(ex.getFieldError()).getDefaultMessage()).build()).getBaseResponse());
    }
}