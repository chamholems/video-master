package com.holems.video.master.refactor.enums;

import lombok.Getter;

/**
 * 缩放算法枚举
 */
@Getter
public enum ScalingAlgorithm {
    BICUBIC("bicubic", "双三次插值"),
    BILINEAR("bilinear", "双线性插值"),
    LANCZOS("lanczos", "Lanczos插值"),
    NEAREST("nearest", "最近邻插值"),
    AREA("area", "区域平均"),
    SPLINE("spline", "样条插值");

    private final String ffmpegAlgorithm;
    private final String description;

    ScalingAlgorithm(String ffmpegAlgorithm, String description) {
        this.ffmpegAlgorithm = ffmpegAlgorithm;
        this.description = description;
    }
}
