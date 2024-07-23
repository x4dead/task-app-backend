package kg.ab.commons.response.exeption;

import kg.ab.commons.enums.StatusCode;
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

