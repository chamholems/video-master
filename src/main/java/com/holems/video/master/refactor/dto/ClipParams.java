package com.holems.video.master.refactor.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 剪辑参数
 */
@Data
@Builder
public class ClipParams {
    private Double startTime;  // 开始时间（秒）
    private Double endTime;    // 结束时间（秒）
    private Boolean autoClip;  // 智能剪辑
    private Integer targetDuration; // 目标时长（秒）
}
