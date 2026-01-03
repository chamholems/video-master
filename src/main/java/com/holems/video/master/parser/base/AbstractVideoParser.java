package com.holems.video.master.parser.base;

import com.holems.video.master.parser.dto.VideoInfo;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * 视频解析器抽象基类
 */
public abstract class AbstractVideoParser implements VideoParser {

    @Autowired
    protected OkHttpClient httpClient;

    // 平台标识（如 "douyin"）
    public abstract String getPlatformKey();

    // 平台名称（如 "抖音"）
    public abstract String getPlatformName();

    // 支持的域名模式
    public abstract String[] getDomainPatterns();

    // URL预处理
    public String preprocessUrl(String url) {
        return url; // 默认不处理，子类可覆盖
    }

    // 解析视频
    public abstract VideoInfo parse(String url) throws Exception;
}