package com.holems.video.master.refactor.constant;

/**
 * 视频处理常量
 */
public class VideoConstants {

    // 视频分辨率
    public static final String RESOLUTION_240P = "426x240";
    public static final String RESOLUTION_360P = "640x360";
    public static final String RESOLUTION_480P = "854x480";
    public static final String RESOLUTION_720P = "1280x720";
    public static final String RESOLUTION_1080P = "1920x1080";
    public static final String RESOLUTION_2K = "2560x1440";
    public static final String RESOLUTION_4K = "3840x2160";

    // 视频比例
    public static final String ASPECT_RATIO_16_9 = "16:9";
    public static final String ASPECT_RATIO_9_16 = "9:16";
    public static final String ASPECT_RATIO_1_1 = "1:1";
    public static final String ASPECT_RATIO_4_3 = "4:3";
    public static final String ASPECT_RATIO_21_9 = "21:9";

    // 帧率
    public static final int FRAME_RATE_24 = 24;
    public static final int FRAME_RATE_25 = 25;
    public static final int FRAME_RATE_30 = 30;
    public static final int FRAME_RATE_50 = 50;
    public static final int FRAME_RATE_60 = 60;
    public static final int FRAME_RATE_120 = 120;

    // 视频码率 (kbps)
    public static final int BITRATE_LOW = 500;
    public static final int BITRATE_MEDIUM = 2000;
    public static final int BITRATE_HIGH = 5000;
    public static final int BITRATE_VERY_HIGH = 10000;

    // 音频码率 (kbps)
    public static final int AUDIO_BITRATE_LOW = 64;
    public static final int AUDIO_BITRATE_MEDIUM = 128;
    public static final int AUDIO_BITRATE_HIGH = 192;
    public static final int AUDIO_BITRATE_VERY_HIGH = 320;

    // 音频采样率 (Hz)
    public static final int SAMPLE_RATE_8000 = 8000;
    public static final int SAMPLE_RATE_16000 = 16000;
    public static final int SAMPLE_RATE_22050 = 22050;
    public static final int SAMPLE_RATE_44100 = 44100;
    public static final int SAMPLE_RATE_48000 = 48000;
    public static final int SAMPLE_RATE_96000 = 96000;

    // 最大文件大小 (MB)
    public static final long MAX_FILE_SIZE_SMALL = 100;  // 100MB
    public static final long MAX_FILE_SIZE_MEDIUM = 500; // 500MB
    public static final long MAX_FILE_SIZE_LARGE = 1024; // 1GB

    // 默认值
    public static final String DEFAULT_FORMAT = "mp4";
    public static final String DEFAULT_RESOLUTION = RESOLUTION_1080P;
    public static final int DEFAULT_FRAME_RATE = FRAME_RATE_30;
    public static final int DEFAULT_VIDEO_BITRATE = BITRATE_MEDIUM;
    public static final int DEFAULT_AUDIO_BITRATE = AUDIO_BITRATE_MEDIUM;
    public static final int DEFAULT_SAMPLE_RATE = SAMPLE_RATE_44100;
    public static final int DEFAULT_AUDIO_CHANNELS = 2;

    // 处理超时时间 (秒)
    public static final int PROCESS_TIMEOUT_SHORT = 300;   // 5分钟
    public static final int PROCESS_TIMEOUT_MEDIUM = 1800; // 30分钟
    public static final int PROCESS_TIMEOUT_LONG = 3600;   // 1小时

    // 并发限制
    public static final int MAX_CONCURRENT_JOBS = 10;
    public static final int MAX_CONCURRENT_DOWNLOADS = 5;
    public static final int MAX_CONCURRENT_UPLOADS = 3;
}
