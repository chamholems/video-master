package com.holems.video.master.common.exception;


import com.holems.video.master.common.response.ApiResponse;
import com.holems.video.master.common.response.ResponseCode;
import com.holems.video.master.common.response.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public ApiResponse<?> handleBusinessException(BusinessException e, HttpServletRequest request) {
        log.warn("业务异常: {} - {}", e.getCode(), e.getMessage());
        return ResponseUtil.error(e.getCode(), e.getMessage());
    }

    /**
     * 处理视频解析异常
     */
    @ExceptionHandler(VideoParseException.class)
    public ApiResponse<?> handleVideoParseException(VideoParseException e, HttpServletRequest request) {
        log.error("视频解析异常 - URL: {}, 平台: {}", e.getUrl(), e.getPlatform(), e);

        Map<String, Object> data = new HashMap<>();
        data.put("url", e.getUrl());
        data.put("platform", e.getPlatform());

        return ResponseUtil.error(e.getCode(), e.getMessage(), data);
    }

    /**
     * 处理参数验证异常
     */
    @ExceptionHandler(ValidationException.class)
    public ApiResponse<?> handleValidationException(ValidationException e, HttpServletRequest request) {
        log.warn("参数验证异常: {}", e.getMessage());

        Map<String, Object> data = new HashMap<>();
        data.put("errors", e.getErrors());

        return ResponseUtil.error(e.getCode(), e.getMessage(), data);
    }

    /**
     * 处理参数绑定异常
     */
    @ExceptionHandler(BindException.class)
    public ApiResponse<?> handleBindException(BindException e, HttpServletRequest request) {
        String message = e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining("; "));

        log.warn("参数绑定异常: {}", message);
        return ResponseUtil.error(ResponseCode.PARAM_VALID_ERROR.getCode(), message);
    }

    /**
     * 处理方法参数验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e,
                                                                HttpServletRequest request) {
        Map<String, String> errors = e.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        fieldError -> fieldError.getDefaultMessage() != null ?
                                fieldError.getDefaultMessage() : "参数错误"
                ));

        String message = e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining("; "));

        log.warn("方法参数验证异常: {}", message);

        Map<String, Object> data = new HashMap<>();
        data.put("errors", errors);

        return ResponseUtil.error(ResponseCode.PARAM_VALID_ERROR.getCode(), message, data);
    }

    /**
     * 处理约束违反异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ApiResponse<?> handleConstraintViolationException(ConstraintViolationException e,
                                                             HttpServletRequest request) {
        String message = e.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("; "));

        log.warn("约束违反异常: {}", message);
        return ResponseUtil.error(ResponseCode.PARAM_VALID_ERROR.getCode(), message);
    }

    /**
     * 处理参数类型不匹配异常
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ApiResponse<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e,
                                                                    HttpServletRequest request) {
        String message = String.format("参数 '%s' 类型不匹配，应为 %s 类型",
                e.getName(),
                e.getRequiredType() != null ? e.getRequiredType().getSimpleName() : "未知类型");

        log.warn("参数类型不匹配异常: {}", message);
        return ResponseUtil.error(ResponseCode.BAD_REQUEST.getCode(), message);
    }

    /**
     * 处理404异常
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ApiResponse<?> handleNoHandlerFoundException(NoHandlerFoundException e,
                                                        HttpServletRequest request) {
        String message = String.format("接口 %s %s 不存在",
                e.getHttpMethod(), e.getRequestURL());

        log.warn("接口不存在: {}", message);
        return ResponseUtil.error(ResponseCode.NOT_FOUND.getCode(), message);
    }

    /**
     * 处理空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    public ApiResponse<?> handleNullPointerException(NullPointerException e,
                                                     HttpServletRequest request) {
        log.error("空指针异常", e);
        return ResponseUtil.error(ResponseCode.ERROR.getCode(), "服务器内部错误");
    }

    /**
     * 处理所有未捕获的异常
     */
    @ExceptionHandler(Exception.class)
    public ApiResponse<?> handleException(Exception e, HttpServletRequest request) {
        log.error("未捕获的异常", e);

        // 生产环境隐藏详细错误信息
        String message = "prod".equals(request.getServletContext().getInitParameter("spring.profiles.active")) ?
                "服务器内部错误，请联系管理员" : e.getMessage();

        return ResponseUtil.error(ResponseCode.ERROR.getCode(), message);
    }
}
