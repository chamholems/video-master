package com.holems.video.master.refactor.enums;

import lombok.Getter;

/**
 * 编码预设枚举
 */
@Getter
public enum EncodingPreset {
    ULTRAFAST("ultrafast", "最快，质量最低"),
    SUPERFAST("superfast", "超快"),
    VERYFAST("veryfast", "非常快"),
    FASTER("faster", "较快"),
    FAST("fast", "快速"),
    MEDIUM("medium", "中等（默认）"),
    SLOW("slow", "较慢"),
    SLOWER("slower", "慢"),
    VERYSLOW("veryslow", "非常慢，质量最高");

    private final String ffmpegPreset;
    private final String description;

    EncodingPreset(String ffmpegPreset, String description) {
        this.ffmpegPreset = ffmpegPreset;
        this.description = description;
    }
}
