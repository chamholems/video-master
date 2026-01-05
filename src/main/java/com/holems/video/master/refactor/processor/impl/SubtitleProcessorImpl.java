package com.holems.video.master.refactor.processor.impl;

import com.holems.video.master.refactor.dto.SubtitleItem;
import com.holems.video.master.refactor.dto.SubtitleParams;
import com.holems.video.master.refactor.dto.SubtitleStyle;
import com.holems.video.master.refactor.dto.result.SubtitleProcessResult;
import com.holems.video.master.refactor.processor.SubtitleProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SubtitleProcessorImpl implements SubtitleProcessor {
    @Override
    public SubtitleProcessResult process(String videoPath, String workDir, SubtitleParams params) {
        return null;
    }

    @Override
    public String removeOriginalSubtitles(String videoPath, String workDir) {
        return "";
    }

    @Override
    public String addSubtitles(String videoPath, String workDir, List<SubtitleItem> subtitles, SubtitleStyle style) {
        return "";
    }

    @Override
    public List<SubtitleItem> translateSubtitles(List<SubtitleItem> subtitles, String targetLanguage) {
        return List.of();
    }

//    @Override
//    public String generateSubtitleFile(List<SubtitleItem> subtitles, String workDir, SubtitleFormat format) {
//        return "";
//    }

    @Override
    public String renderSubtitles(String videoPath, String subtitlePath, String workDir, SubtitleStyle style) {
        return "";
    }
}
