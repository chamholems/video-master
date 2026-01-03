package com.holems.video.master.parser.service;

import com.holems.video.master.parser.base.AbstractVideoParser;
import com.holems.video.master.parser.dto.VideoInfo;
import com.holems.video.master.parser.util.PlatformMatcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 视频解析服务
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class VideoParserService {

    private final PlatformMatcher platformMatcher;

    /**
     * 解析视频
     */
    public VideoInfo parse(String rawUrl) {
        try {
            // 1. 匹配平台
            String platform = platformMatcher.matchPlatform(rawUrl);
            if (platform == null) {
                return VideoInfo.error("unknown", rawUrl, "不支持的平台");
            }

            // 2. 获取解析器
            AbstractVideoParser parser = platformMatcher.getParser(platform);
            if (parser == null) {
                return VideoInfo.error(platform, rawUrl, "平台解析器未实现");
            }

            // 3. 预处理URL
            String processedUrl = parser.preprocessUrl(rawUrl);

            // 4. 解析视频
            VideoInfo videoInfo = parser.parse(processedUrl);
            videoInfo.setPlatform(platform);
            videoInfo.setOriginalUrl(rawUrl);

            return videoInfo;

        } catch (Exception e) {
            log.error("解析失败: {}", rawUrl, e);
            return VideoInfo.error("unknown", rawUrl, "解析失败: " + e.getMessage());
        }
    }

    /**
     * 获取支持的平台
     */
    public Map<String, String> getSupportedPlatforms() {
        return platformMatcher.getAllPlatforms();
    }

    /**
     * 检查是否支持
     */
    public boolean isSupported(String url) {
        return platformMatcher.matchPlatform(url) != null;
    }
}