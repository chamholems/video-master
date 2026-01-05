package com.holems.video.master.refactor.dto;

import com.holems.video.master.refactor.enums.AudioCodec;
import com.holems.video.master.refactor.enums.EncodingPreset;
import com.holems.video.master.refactor.enums.ScalingAlgorithm;
import com.holems.video.master.refactor.enums.VideoCodec;
import lombok.Data;
import lombok.Builder;

/**
 * 视频压缩参数
 */
@Data
@Builder
public class CompressionParams {

    // 视频编码器
    private VideoCodec codec;

    // 视频码率 (kbps)
    private Integer videoBitrate;

    // 音频码率 (kbps)
    private Integer audioBitrate;

    // 恒定质量 (CRF, 0-51)
    private Integer crf;

    // 预设（编码速度）
    private EncodingPreset preset;

    // 分辨率
    private String resolution;

    // 帧率
    private Integer frameRate;

    // 关键帧间隔
    private Integer keyframeInterval;

    // 压缩级别 (1-9)
    private Integer compressionLevel;

    // 是否二次编码
    private Boolean twoPassEncoding;

    // 音频编码器
    private AudioCodec audioCodec;

    // 音频采样率 (Hz)
    private Integer audioSampleRate;

    // 音频声道数
    private Integer audioChannels;

    // 是否去除元数据
    private Boolean stripMetadata;

    // 是否优化移动端播放
    private Boolean optimizeForMobile;

    // 目标文件大小 (MB)
    private Integer targetSize;

    // 最大文件大小 (MB)
    private Integer maxSize;

    // 是否保持原始宽高比
    private Boolean keepAspectRatio;

    // 缩放算法
    private ScalingAlgorithm scalingAlgorithm;
}
