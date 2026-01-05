package com.holems.video.master.refactor.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 音频处理参数
 */
@Data
@Builder
public class AudioProcessParams {
    private String targetMusic;        // 目标音乐
    private Boolean keepOriginalBGM;   // 保留原背景音乐
    private Double musicVolume;        // 音乐音量 (0.0-1.0)
    private Double voiceVolume;        // 人声音量 (0.0-1.0)
    private Boolean noiseReduction;    // 降噪
}
