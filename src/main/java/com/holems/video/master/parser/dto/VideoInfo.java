package com.holems.video.master.parser.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoInfo {
    // 平台信息
    private String platform;
    private String originalUrl;

    // 视频基本信息
    private String title;
    private String description;

    // 视频媒体信息
    private String videoUrl;
    private String coverImage;
    private Long duration; // 视频时长（秒）
    private String videoId;
    private Integer width;
    private Integer height;
    private String ratio;

    // 作者信息
    private String author;
    private String authorId;
    private String authorAvatar;

    // 统计信息
    private Long likeCount;
    private Long commentCount;
    private Long shareCount;
    private Long viewCount;
    private Long collectCount;

    // 时间信息
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private LocalDateTime parseTime;

    // 扩展信息
    private Map<String, Object> musicInfo;
    private Map<String, Object> extraInfo;

    // 状态信息
    private Boolean success;
    private String errorMessage;
    private Integer httpCode;

    // 工厂方法
    public static VideoInfo success(String platform, String originalUrl) {
        return VideoInfo.builder()
                .platform(platform)
                .originalUrl(originalUrl)
                .success(true)
                .parseTime(LocalDateTime.now())
                .httpCode(200)
                .build();
    }

    public static VideoInfo error(String platform, String originalUrl, String errorMessage) {
        return VideoInfo.builder()
                .platform(platform)
                .originalUrl(originalUrl)
                .success(false)
                .errorMessage(errorMessage)
                .parseTime(LocalDateTime.now())
                .httpCode(500)
                .build();
    }
}
