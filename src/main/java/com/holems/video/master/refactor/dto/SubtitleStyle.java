package com.holems.video.master.refactor.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 字幕样式
 */
@Data
@Builder
public class SubtitleStyle {
    private String fontFamily;         // 字体
    private Integer fontSize;          // 字体大小
    private String fontColor;          // 字体颜色
    private String backgroundColor;    // 背景颜色
    private Double backgroundOpacity;  // 背景透明度
    private Boolean bold;              // 加粗
    private Boolean italic;            // 斜体
    private Boolean underline;         // 下划线
    private String position;           // 位置（top, bottom, middle）
}
