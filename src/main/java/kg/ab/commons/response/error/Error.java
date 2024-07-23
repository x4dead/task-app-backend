package kg.ab.commons.response.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import kg.ab.commons.enums.StatusCode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Error {
    private StatusCode code;
    private String message;
}
