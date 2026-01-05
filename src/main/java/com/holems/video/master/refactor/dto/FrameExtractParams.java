package com.holems.video.master.refactor.dto;

import com.holems.video.master.refactor.enums.ExtractStrategy;
import com.holems.video.master.refactor.enums.TimestampFormat;
import lombok.Builder;
import lombok.Data;

/**
 * 帧抽取参数
 */
@Data
@Builder
public class FrameExtractParams {

    // 抽取策略
    private ExtractStrategy strategy;

    // 固定间隔（秒）
    private Double interval;

    // 固定帧数
    private Integer frameCount;

    // 场景变化阈值 (0.0-1.0)
    private Double sceneThreshold;

    // 是否抽取关键帧
    private Boolean extractKeyFrames;

    // 最大抽取数量
    private Integer maxExtractCount;

    // 输出格式
    private String outputFormat;

    // 输出质量 (1-100)
    private Integer quality;

    // 是否包含时间戳
    private Boolean includeTimestamp;

    // 时间戳格式
    private TimestampFormat timestampFormat;
}

