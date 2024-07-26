package kg.ab.commons.exeption;

import kg.ab.dto.BaseResponse;
import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {
    private final BaseResponse<Object> baseResponse;

    public CommonException(BaseResponse<Object> baseResponse) {
        this.baseResponse = baseResponse;
    }

}

