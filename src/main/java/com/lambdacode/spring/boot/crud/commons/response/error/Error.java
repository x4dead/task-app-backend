package com.lambdacode.spring.boot.crud.commons.response.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lambdacode.spring.boot.crud.commons.enums.StatusCode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Error {
    private StatusCode code;
    private String message;
}
