package com.holems.video.master.common.exception;

import com.holems.video.master.common.response.ResponseCode;
import lombok.Getter;

/**
 * 视频解析异常
 */
@Getter
public class VideoParseException extends BusinessException {

    private final String url;
    private final String platform;

    public VideoParseException(String url, String message) {
        super(ResponseCode.VIDEO_PARSE_ERROR.getCode(), message);
        this.url = url;
        this.platform = null;
    }

    public VideoParseException(String url, String platform, String message) {
        super(ResponseCode.VIDEO_PARSE_ERROR.getCode(), message);
        this.url = url;
        this.platform = platform;
    }

    public VideoParseException(String url, String platform, String message, Throwable cause) {
        super(ResponseCode.VIDEO_PARSE_ERROR.getCode(), message, cause);
        this.url = url;
        this.platform = platform;
    }

    public VideoParseException(ResponseCode responseCode, String url, String platform) {
        super(responseCode);
        this.url = url;
        this.platform = platform;
    }
}
