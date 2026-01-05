package com.holems.video.master.refactor.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 视频处理参数
 */
@Data
@Builder
public class VideoProcessParams {
    private Boolean smartMirror;       // 智能镜像
    private Boolean removeWatermark;   // 去除视频指纹/水印
    private Boolean smartTransitions;  // 智能转场
    private Boolean smartAcceleration; // 智能加速
    private Boolean smartMoving;       // 智能移动
    private Boolean smartZoom;         // 智能缩放
    private Boolean smartColorAdjust;  // 智能调色
    private Boolean sharpening;        // 画面锐化
    private Boolean mirrorFlip;        // 镜像反转
    private Boolean smartFrameExtract; // 智能抽帧
    private Integer frameRate;         // 帧率
    private String resolution;         // 分辨率
}

