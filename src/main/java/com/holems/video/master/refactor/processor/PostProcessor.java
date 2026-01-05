package com.holems.video.master.refactor.processor;

import com.holems.video.master.refactor.dto.CompressionParams;
import com.holems.video.master.refactor.dto.OtherParams;
import com.holems.video.master.refactor.dto.ProgressBarStyle;

import java.util.Map;

/**
 * 后处理器接口
 */
public interface PostProcessor {

    /**
     * 后处理
     */
    String process(String videoPath, OtherParams params);

    /**
     * 添加进度条
     */
    String addProgressBar(String videoPath, String workDir, ProgressBarStyle style);

    /**
     * 修改视频元数据
     */
    String modifyMetadata(String videoPath, String workDir, Map<String, String> metadata);

    /**
     * 格式转换
     */
    String convertFormat(String videoPath, String workDir, String targetFormat, Integer quality);

    /**
     * 压缩视频
     */
    String compressVideo(String videoPath, String workDir, CompressionParams params);
}
