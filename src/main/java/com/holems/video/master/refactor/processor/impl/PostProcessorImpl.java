package com.holems.video.master.refactor.processor.impl;

import com.holems.video.master.refactor.dto.CompressionParams;
import com.holems.video.master.refactor.dto.OtherParams;
import com.holems.video.master.refactor.dto.ProgressBarStyle;
import com.holems.video.master.refactor.processor.PostProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class PostProcessorImpl implements PostProcessor {
    @Override
    public String process(String videoPath, OtherParams params) {
        return "";
    }

    @Override
    public String addProgressBar(String videoPath, String workDir, ProgressBarStyle style) {
        return "";
    }

    @Override
    public String modifyMetadata(String videoPath, String workDir, Map<String, String> metadata) {
        return "";
    }

    @Override
    public String convertFormat(String videoPath, String workDir, String targetFormat, Integer quality) {
        return "";
    }

    @Override
    public String compressVideo(String videoPath, String workDir, CompressionParams params) {
        return "";
    }
}
