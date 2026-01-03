package com.holems.video.master.parser.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import com.holems.video.master.parser.base.AbstractVideoParser;
import java.util.List;

/**
 * 平台匹配器
 */
@Component
public class PlatformMatcher {

    private final Map<String, AbstractVideoParser> parsers = new HashMap<>();
    private final Map<String, Pattern> urlPatterns = new HashMap<>();

    public PlatformMatcher(List<AbstractVideoParser> parserList) {
        // 注册所有解析器
        for (AbstractVideoParser parser : parserList) {
            String platform = parser.getPlatformKey();
            parsers.put(platform, parser);

            // 构建URL匹配模式
            StringBuilder patternBuilder = new StringBuilder();
            for (String domain : parser.getDomainPatterns()) {
                if (!patternBuilder.isEmpty()) {
                    patternBuilder.append("|");
                }
                patternBuilder.append("(?:https?://[^/]*").append(domain).append(")");
            }

            urlPatterns.put(platform, Pattern.compile(patternBuilder.toString()));
        }
    }

    /**
     * 匹配平台
     */
    public String matchPlatform(String url) {
        if (url == null || url.trim().isEmpty()) {
            return null;
        }

        url = url.toLowerCase().trim();

        // 检查特殊短链接
        if (url.contains(":/") && !url.startsWith("http")) {
            return "douyin"; // 默认抖音特殊链接
        }

        // 检查HTTP链接
        for (Map.Entry<String, Pattern> entry : urlPatterns.entrySet()) {
            if (entry.getValue().matcher(url).find()) {
                return entry.getKey();
            }
        }

        return null;
    }

    /**
     * 获取解析器
     */
    public AbstractVideoParser getParser(String platform) {
        return parsers.get(platform);
    }

    /**
     * 获取所有平台
     */
    public Map<String, String> getAllPlatforms() {
        Map<String, String> platforms = new HashMap<>();
        parsers.forEach((key, parser) -> {
            platforms.put(key, parser.getPlatformName());
        });
        return platforms;
    }
}