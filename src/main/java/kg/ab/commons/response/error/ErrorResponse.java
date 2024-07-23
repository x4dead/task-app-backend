package com.lambdacode.spring.boot.crud.commons.response.error;
import com.lambdacode.spring.boot.crud.commons.response.Response;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse implements Response {

    private Error error;
}