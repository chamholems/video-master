package com.holems.video.master.refactor.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 字幕背景
 */
@Data
@Builder
public class SubtitleBackground {
    private String type;               // 类型（none, solid, blur）
    private String color;              // 颜色
    private Integer blurRadius;        // 模糊半径
    private Double opacity;            // 透明度
}
