package com.holems.video.master.common.exception;

import lombok.Getter;

/**
 * 全局异常基类
 */
@Getter
public class GlobalException extends RuntimeException {

    private final Integer code;
    private final String message;

    public GlobalException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public GlobalException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }
}
