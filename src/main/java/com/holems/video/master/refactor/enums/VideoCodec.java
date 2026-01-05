package com.holems.video.master.refactor.enums;

import lombok.Getter;

/**
 * 视频编码器枚举
 */
@Getter
public enum VideoCodec {
    H264("H.264", "libx264"),
    H265("H.265/HEVC", "libx265"),
    VP9("VP9", "libvpx-vp9"),
    AV1("AV1", "libaom-av1"),
    MPEG4("MPEG-4", "mpeg4"),
    MPEG2("MPEG-2", "mpeg2video"),
    VP8("VP8", "libvpx"),
    THEORA("Theora", "libtheora");

    private final String name;
    private final String ffmpegCodec;

    VideoCodec(String name, String ffmpegCodec) {
        this.name = name;
        this.ffmpegCodec = ffmpegCodec;
    }
}
