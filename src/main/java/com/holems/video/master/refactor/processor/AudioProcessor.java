package com.holems.video.master.refactor.processor;

import com.holems.video.master.refactor.dto.AudioMixParams;
import com.holems.video.master.refactor.dto.AudioProcessParams;
import com.holems.video.master.refactor.dto.result.AudioProcessResult;

/**
 * 音频处理器接口
 */
public interface AudioProcessor {

    /**
     * 处理音频
     */
    AudioProcessResult process(String videoPath, String workDir, AudioProcessParams params);

    /**
     * 提取音频
     */
    String extractAudio(String videoPath, String workDir);

    /**
     * 匹配音乐
     */
    String matchMusic(String audioPath, String targetMusic, Double similarity);

    /**
     * 保留背景音乐
     */
    String keepBackgroundMusic(String videoPath, String workDir);

    /**
     * 音量调整
     */
    String adjustVolume(String audioPath, String workDir, Double volume);

    /**
     * 降噪处理
     */
    String noiseReduction(String audioPath, String workDir);

    /**
     * 音频合成
     */
    String mixAudio(String originalAudioPath, String musicPath, String voicePath, String workDir, AudioMixParams params);
}
