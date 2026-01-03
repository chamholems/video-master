package com.holems.video.master.common.response;

import lombok.Getter;

/**
 * 响应状态码枚举
 */
@Getter
public enum ResponseCode {

    // 成功状态码
    SUCCESS(200, "操作成功"),

    // 客户端错误 400-499
    BAD_REQUEST(400, "请求参数错误"),
    UNAUTHORIZED(401, "未授权访问"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源不存在"),
    METHOD_NOT_ALLOWED(405, "请求方法不允许"),

    // 服务器错误 500-599
    ERROR(500, "服务器内部错误"),
    SERVICE_UNAVAILABLE(503, "服务暂时不可用"),

    // 业务状态码 1000-1999
    BUSINESS_ERROR(1000, "业务异常"),
    DATA_NOT_FOUND(1001, "数据不存在"),
    DATA_EXISTS(1002, "数据已存在"),
    PARAM_VALID_ERROR(1003, "参数验证失败"),
    DATA_UPDATE_ERROR(1004, "数据更新失败"),

    // 用户相关 2000-2999
    USER_NOT_EXIST(2001, "用户不存在"),
    USER_PASSWORD_ERROR(2002, "密码错误"),
    USER_DISABLED(2003, "用户已被禁用"),
    USER_EXISTS(2004, "用户已存在"),

    // 权限相关 3000-3999
    PERMISSION_DENIED(3001, "权限不足"),
    TOKEN_EXPIRED(3002, "Token已过期"),
    TOKEN_INVALID(3003, "Token无效"),

    // 文件相关 4000-4999
    FILE_UPLOAD_ERROR(4001, "文件上传失败"),
    FILE_NOT_FOUND(4002, "文件不存在"),
    FILE_SIZE_EXCEED(4003, "文件大小超过限制"),
    FILE_TYPE_NOT_ALLOWED(4004, "文件类型不允许"),

    // 第三方服务 5000-5999
    THIRD_PARTY_ERROR(5001, "第三方服务异常"),
    API_RATE_LIMIT(5002, "接口访问频率限制"),
    API_CALL_FAILED(5003, "接口调用失败"),

    // 视频解析相关 6000-6999
    VIDEO_PARSE_ERROR(6001, "视频解析失败"),
    VIDEO_PLATFORM_NOT_SUPPORTED(6002, "视频平台不支持"),
    VIDEO_URL_INVALID(6003, "视频链接无效"),
    VIDEO_NOT_FOUND(6004, "视频不存在"),
    VIDEO_DOWNLOAD_FAILED(6005, "视频下载失败");

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 状态信息
     */
    private final String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 根据code获取枚举
     */
    public static ResponseCode getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (ResponseCode responseCode : values()) {
            if (responseCode.getCode().equals(code)) {
                return responseCode;
            }
        }
        return null;
    }

    /**
     * 判断是否为成功状态码
     */
    public static boolean isSuccess(Integer code) {
        return code != null && code >= 200 && code < 300;
    }

    /**
     * 判断是否为客户端错误
     */
    public static boolean isClientError(Integer code) {
        return code != null && code >= 400 && code < 500;
    }

    /**
     * 判断是否为服务器错误
     */
    public static boolean isServerError(Integer code) {
        return code != null && code >= 500 && code < 600;
    }
}
