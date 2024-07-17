package com.lambdacode.spring.boot.crud.response.error;
import  com.lambdacode.spring.boot.crud.response.Response;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse implements Response {

    private Error error;
}