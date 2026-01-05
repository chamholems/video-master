package com.holems.video.master.refactor.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 压缩器设置
 */
@Data
@Builder
public class CompressorSettings {
    private Double threshold;   // 阈值 (dB)
    private Double ratio;       // 压缩比 (1:1 到 20:1)
    private Double attack;      // 启动时间 (ms)
    private Double release;     // 释放时间 (ms)
    private Double makeup;      // 增益补偿 (dB)
}
