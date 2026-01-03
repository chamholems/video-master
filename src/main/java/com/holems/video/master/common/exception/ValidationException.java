package com.holems.video.master.common.exception;

import com.holems.video.master.common.response.ResponseCode;
import lombok.Getter;

import java.util.Map;

/**
 * 参数验证异常
 */
@Getter
public class ValidationException extends BusinessException {

    private Map<String, String> errors;

    public ValidationException(String message) {
        super(ResponseCode.PARAM_VALID_ERROR.getCode(), message);
    }

    public ValidationException(Map<String, String> errors) {
        super(ResponseCode.PARAM_VALID_ERROR);
        this.errors = errors;
    }

    public ValidationException(String message, Map<String, String> errors) {
        super(ResponseCode.PARAM_VALID_ERROR.getCode(), message);
        this.errors = errors;
    }
}
