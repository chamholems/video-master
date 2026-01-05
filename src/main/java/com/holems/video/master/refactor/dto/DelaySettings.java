package com.holems.video.master.refactor.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 延迟设置
 */
@Data
@Builder
public class DelaySettings {
    private Double time;        // 延迟时间 (ms)
    private Double feedback;    // 反馈 (0.0-1.0)
    private Double mix;         // 混合比例 (0.0-1.0)
}
