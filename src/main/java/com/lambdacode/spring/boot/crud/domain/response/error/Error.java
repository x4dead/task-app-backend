package com.lambdacode.spring.boot.crud.domain.response.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lambdacode.spring.boot.crud.domain.constants.Code;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Error {
    private Code code;
    private String message;
}
