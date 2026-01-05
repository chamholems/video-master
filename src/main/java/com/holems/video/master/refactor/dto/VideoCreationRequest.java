package com.holems.video.master.refactor.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 二创请求参数
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoCreationRequest {

    // 基础信息
    private String originalVideoUrl;
    private String title;
    private String description;
    private List<String> tags;
    private Map<String, String> extraInfo;

    // 剪辑参数
    private ClipParams clipParams;

    // 视频处理参数
    private VideoProcessParams videoProcessParams;

    // 音频处理参数
    private AudioProcessParams audioProcessParams;

    // 字幕处理参数
    private SubtitleParams subtitleParams;

    // 其他参数
    private OtherParams otherParams;

    // 输出参数
    private OutputParams outputParams;
}
