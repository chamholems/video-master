package com.holems.video.master.refactor.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 均衡器设置
 */
@Data
@Builder
public class EqualizerSettings {
    private Double low;      // 低频 (31.25-500Hz)
    private Double mid;      // 中频 (500-2000Hz)
    private Double high;     // 高频 (2000-16000Hz)
    private Double bass;     // 低音增强 (-12.0-12.0)
    private Double treble;   // 高音增强 (-12.0-12.0)
    private String preset;   // 预设
}
