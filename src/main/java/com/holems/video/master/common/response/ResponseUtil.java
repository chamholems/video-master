package com.holems.video.master.common.response;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.holems.video.master.common.utils.JsonUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 响应工具类
 */
public class ResponseUtil {

    /**
     * 返回成功响应
     */
    public static <T> ApiResponse<T> success() {
        return ApiResponse.success();
    }

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.success(data);
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return ApiResponse.success(data, message);
    }

    /**
     * 返回失败响应
     */
    public static <T> ApiResponse<T> error() {
        return ApiResponse.error();
    }

    public static <T> ApiResponse<T> error(String message) {
        return ApiResponse.error(message);
    }

    public static <T> ApiResponse<T> error(Integer code, String message) {
        return ApiResponse.error(code, message);
    }

    public static <T> ApiResponse<T> error(ResponseCode responseCode) {
        return ApiResponse.error(responseCode);
    }

    public static <T> ApiResponse<T> error(Integer code, String message, T data) {
        return ApiResponse.error(code, message, data);
    }

    /**
     * 返回分页成功响应
     */
    public static <T> ApiResponse<PageResponse<T>> pageSuccess(IPage<T> page) {
        PageResponse<T> pageResponse = PageResponse.from(page);
        return ApiResponse.success(pageResponse);
    }

    /**
     * 返回分页成功响应（自定义消息）
     */
    public static <T> ApiResponse<PageResponse<T>> pageSuccess(IPage<T> page, String message) {
        PageResponse<T> pageResponse = PageResponse.from(page);
        return ApiResponse.success(pageResponse, message);
    }

    /**
     * 直接输出JSON响应
     */
    public static void writeJson(HttpServletResponse response,
                                 HttpStatus status,
                                 ApiResponse<?> apiResponse) throws IOException {
        response.setStatus(status.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());

        String json = JsonUtil.toJson(apiResponse);
        response.getWriter().write(json);
    }

    /**
     * 输出错误JSON响应
     */
    public static void writeErrorJson(HttpServletResponse response,
                                      HttpStatus status,
                                      String message) throws IOException {
        ApiResponse<?> apiResponse = ApiResponse.error(status.value(), message);
        writeJson(response, status, apiResponse);
    }

    /**
     * 输出错误JSON响应（带响应码）
     */
    public static void writeErrorJson(HttpServletResponse response,
                                      ResponseCode responseCode) throws IOException {
        ApiResponse<?> apiResponse = ApiResponse.error(responseCode);
        writeJson(response, HttpStatus.valueOf(responseCode.getCode()), apiResponse);
    }
}
