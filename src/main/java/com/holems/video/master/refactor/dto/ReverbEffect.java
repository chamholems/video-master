package com.holems.video.master.refactor.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 混响效果
 */
@Data
@Builder
public class ReverbEffect {
    private Double roomSize;    // 房间大小 (0.0-1.0)
    private Double damping;     // 阻尼 (0.0-1.0)
    private Double wetLevel;    // 混响强度 (0.0-1.0)
    private Double dryLevel;    // 原声强度 (0.0-1.0)
    private Double width;       // 宽度 (0.0-1.0)
}
