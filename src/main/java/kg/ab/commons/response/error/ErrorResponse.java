package kg.ab.commons.response.error;

import kg.ab.commons.response.Response;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse implements Response {

    private Error error;
}