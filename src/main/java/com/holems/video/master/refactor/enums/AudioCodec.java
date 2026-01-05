package com.holems.video.master.refactor.enums;

import lombok.Getter;

/**
 * 音频编码器枚举
 */
@Getter
public enum AudioCodec {
    AAC("AAC", "aac"),
    MP3("MP3", "libmp3lame"),
    OPUS("Opus", "libopus"),
    VORBIS("Vorbis", "libvorbis"),
    FLAC("FLAC", "flac"),
    PCM("PCM", "pcm_s16le");

    private final String name;
    private final String ffmpegCodec;

    AudioCodec(String name, String ffmpegCodec) {
        this.name = name;
        this.ffmpegCodec = ffmpegCodec;
    }
}
