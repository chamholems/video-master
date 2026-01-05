package com.holems.video.master.refactor.processor.impl;

import com.holems.video.master.refactor.dto.AudioMixParams;
import com.holems.video.master.refactor.dto.AudioProcessParams;
import com.holems.video.master.refactor.dto.result.AudioProcessResult;
import com.holems.video.master.refactor.processor.AudioProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AudioProcessorImpl implements AudioProcessor {
    @Override
    public AudioProcessResult process(String videoPath, String workDir, AudioProcessParams params) {
        return null;
    }

    @Override
    public String extractAudio(String videoPath, String workDir) {
        return "";
    }

    @Override
    public String matchMusic(String audioPath, String targetMusic, Double similarity) {
        return "";
    }

    @Override
    public String keepBackgroundMusic(String videoPath, String workDir) {
        return "";
    }

    @Override
    public String adjustVolume(String audioPath, String workDir, Double volume) {
        return "";
    }

    @Override
    public String noiseReduction(String audioPath, String workDir) {
        return "";
    }

    @Override
    public String mixAudio(String originalAudioPath, String musicPath, String voicePath, String workDir, AudioMixParams params) {
        return "";
    }
}
