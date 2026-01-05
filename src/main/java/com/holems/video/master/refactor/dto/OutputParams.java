package com.holems.video.master.refactor.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 输出参数
 */
@Data
@Builder
public class OutputParams {
    private String format;             // 输出格式
    private Integer quality;           // 质量 (1-100)
    private String watermark;          // 水印文字
    private String outputPath;         // 输出路径
    private Boolean autoUpload;        // 自动上传
    private String platform;           // 上传平台
}
