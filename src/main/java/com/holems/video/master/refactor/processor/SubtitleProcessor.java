package com.holems.video.master.refactor.processor;

import com.holems.video.master.refactor.dto.SubtitleItem;
import com.holems.video.master.refactor.dto.SubtitleParams;
import com.holems.video.master.refactor.dto.SubtitleStyle;
import com.holems.video.master.refactor.dto.result.SubtitleProcessResult;

import java.util.List;

/**
 * 字幕处理器接口
 */
public interface SubtitleProcessor {

    /**
     * 处理字幕
     */
    SubtitleProcessResult process(String videoPath, String workDir, SubtitleParams params);

    /**
     * 擦除原字幕
     */
    String removeOriginalSubtitles(String videoPath, String workDir);

    /**
     * 添加新字幕
     */
    String addSubtitles(String videoPath, String workDir, List<SubtitleItem> subtitles, SubtitleStyle style);

    /**
     * 翻译字幕
     */
    List<SubtitleItem> translateSubtitles(List<SubtitleItem> subtitles, String targetLanguage);

//    /**
//     * 生成字幕文件
//     */
//    String generateSubtitleFile(List<SubtitleItem> subtitles, String workDir, SubtitleFormat format);

    /**
     * 字幕样式渲染
     */
    String renderSubtitles(String videoPath, String subtitlePath, String workDir, SubtitleStyle style);
}
