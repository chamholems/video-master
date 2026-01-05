package com.holems.video.master.refactor.processor;

import com.holems.video.master.refactor.dto.ClipParams;
import com.holems.video.master.refactor.dto.ColorAdjustParams;
import com.holems.video.master.refactor.dto.FrameExtractParams;
import com.holems.video.master.refactor.dto.VideoProcessParams;
import com.holems.video.master.refactor.dto.result.VideoProcessResult;

import java.util.List;

/**
 * 视频处理器接口
 */
public interface VideoProcessor {

    /**
     * 处理视频
     */
    VideoProcessResult process(String videoPath, String workDir, VideoProcessParams params);

    /**
     * 智能剪辑
     */
    String smartClip(String videoPath, String workDir, ClipParams params);

    /**
     * 去除水印
     */
    String removeWatermark(String videoPath, String workDir);

    /**
     * 智能镜像
     */
    String smartMirror(String videoPath, String workDir);

    /**
     * 智能转场
     */
    String smartTransitions(String videoPath, String workDir, List<String> transitionTypes);

    /**
     * 智能加速
     */
    String smartAcceleration(String videoPath, String workDir, Double speedFactor);

    /**
     * 智能调色
     */
    String smartColorAdjust(String videoPath, String workDir, ColorAdjustParams params);

    /**
     * 画面锐化
     */
    String sharpen(String videoPath, String workDir, Double sharpness);

    /**
     * 镜像反转
     */
    String mirrorFlip(String videoPath, String workDir);

    /**
     * 智能抽帧
     */
    List<String> smartFrameExtract(String videoPath, String workDir, FrameExtractParams params);
}
