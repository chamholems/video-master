package com.holems.video.master.refactor.dto;

import com.holems.video.master.refactor.enums.FadeCurve;
import lombok.Builder;
import lombok.Data;

/**
 * 淡入淡出设置
 */
@Data
@Builder
public class FadeSettings {
    private Double fadeInDuration;   // 淡入时长（秒）
    private Double fadeOutDuration;  // 淡出时长（秒）
    private FadeCurve fadeInCurve;   // 淡入曲线
    private FadeCurve fadeOutCurve;  // 淡出曲线
}
