package kg.ab.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kg.ab.commons.enums.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {

    private StatusCode result;
    private T data;
}
