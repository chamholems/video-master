package com.holems.video.master.refactor.dto;

import com.holems.video.master.refactor.enums.MixAlgorithm;
import com.holems.video.master.refactor.enums.MusicSyncMode;
import lombok.Builder;
import lombok.Data;

/**
 * 音频混合参数
 */
@Data
@Builder
public class AudioMixParams {

    // 原始音频音量 (0.0-2.0)
    private Double originalVolume;

    // 背景音乐音量 (0.0-2.0)
    private Double bgmVolume;

    // 人声音量 (0.0-2.0)
    private Double voiceVolume;

    // 混响效果
    private ReverbEffect reverb;

    // 均衡器设置
    private EqualizerSettings equalizer;

    // 压缩器设置
    private CompressorSettings compressor;

    // 延迟设置
    private DelaySettings delay;

    // 混音算法
    private MixAlgorithm algorithm;

    // 音频淡入淡出
    private FadeSettings fade;

    // 自动音量平衡
    private Boolean autoVolumeBalance;

    // 是否保留原始人声
    private Boolean keepOriginalVoice;

    // 背景音乐同步方式
    private MusicSyncMode syncMode;

    // 背景音乐循环
    private Boolean bgmLoop;

    // 背景音乐淡入时长（秒）
    private Double bgmFadeIn;

    // 背景音乐淡出时长（秒）
    private Double bgmFadeOut;
}
