package com.holems.video.master.refactor.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 字幕参数
 */
@Data
@Builder
public class SubtitleParams {
    private Boolean removeOriginal;    // 擦除原字幕
    private Boolean addNewSubtitles;   // 覆写新字幕
    private List<SubtitleItem> subtitles; // 字幕内容
    private SubtitleStyle style;       // 字幕样式
    private Boolean translate;         // 翻译字幕
    private String targetLanguage;     // 目标语言
    private SubtitleBackground background; // 字幕背景
}
