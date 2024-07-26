package kg.ab.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum StatusCode {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR),
    TIMEOUT(HttpStatus.IM_USED),
    FAILED(HttpStatus.CONFLICT),
    CREATED(HttpStatus.CREATED),
    OK(HttpStatus.OK),
    UPDATED(HttpStatus.OK),
    DELETED(HttpStatus.OK),
    DECLINED(HttpStatus.GONE),
    ARGUMENT_TYPE_MISMATCH(HttpStatus.BAD_REQUEST),
    BAD_REQUEST(HttpStatus.BAD_REQUEST),
    NOT_FOUND(HttpStatus.NOT_FOUND),
    MISSING_REQUEST_HEADER(HttpStatus.BAD_REQUEST),
    MISSING_PATH_VARIABLE(HttpStatus.BAD_REQUEST),
    NOT_READABLE(HttpStatus.BAD_REQUEST),
    UNDEFINED(HttpStatus.SERVICE_UNAVAILABLE),
    REQUEST_VALIDATION_ERROR(HttpStatus.BAD_REQUEST),
    NOT_SUPPORTED(HttpStatus.BAD_REQUEST);

    private final HttpStatus httpStatus;

    public static StatusCode getByName(String name) {
        for (StatusCode status : StatusCode.values()) {
            if (status.name().equals(name)) {
                return status;
            }
        }
        return UNDEFINED;
    }
}

