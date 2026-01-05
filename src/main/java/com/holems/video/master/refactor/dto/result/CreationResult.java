package com.holems.video.master.refactor.dto.result;

import lombok.Builder;
import lombok.Data;

/**
 * 处理结果类
 */
@Data
@Builder
public class CreationResult {
    private Boolean success;
    private String videoPath;
    private String videoUrl;
    private Integer duration; // 秒
    private Long size; // 字节
    private String errorMessage;
}
