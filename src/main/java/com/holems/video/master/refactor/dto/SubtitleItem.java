package com.holems.video.master.refactor.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 字幕条目
 */
@Data
@Builder
public class SubtitleItem {
    private Double startTime;          // 开始时间（秒）
    private Double endTime;            // 结束时间（秒）
    private String text;               // 字幕文本
    private String translatedText;     // 翻译文本
}
