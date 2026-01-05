package com.holems.video.master.refactor.dto;

import com.holems.video.master.refactor.enums.ColorFilter;
import lombok.Builder;
import lombok.Data;

/**
 * 颜色调整参数
 */
@Data
@Builder
public class ColorAdjustParams {

    // 亮度调整 (-1.0 到 1.0)
    private Double brightness;

    // 对比度调整 (0.0 到 3.0)
    private Double contrast;

    // 饱和度调整 (0.0 到 3.0)
    private Double saturation;

    // 色相调整 (-180 到 180)
    private Double hue;

    // 伽马调整 (0.1 到 10.0)
    private Double gamma;

    // 自动白平衡
    private Boolean autoWhiteBalance;

    // 自动曝光
    private Boolean autoExposure;

    // 色温调整 (1000 到 40000)
    private Integer temperature;

    // 色调调整 (-100 到 100)
    private Integer tint;

    // 高光调整 (-100 到 100)
    private Integer highlights;

    // 阴影调整 (-100 到 100)
    private Integer shadows;

    // 鲜艳度调整 (-100 到 100)
    private Integer vibrance;

    // 去雾强度 (0 到 100)
    private Integer dehaze;

    // 锐化强度 (0 到 100)
    private Integer sharpness;

    // 降噪强度 (0 到 100)
    private Integer denoise;

    // 预设滤镜
    private ColorFilter filter;

    // 是否智能调色
    private Boolean smartAdjust;

    // 目标风格
    private String targetStyle;
}
