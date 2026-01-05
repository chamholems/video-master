package com.holems.video.master.refactor.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 进度条样式
 */
@Data
@Builder
public class ProgressBarStyle {
    private String color;              // 颜色
    private Integer height;            // 高度（像素）
    private String position;           // 位置（top, bottom）
    private Boolean showTime;          // 显示时间
    private Boolean showPercentage;    // 显示百分比
}
