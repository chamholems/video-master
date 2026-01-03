package com.holems.video.master.parser.base;

import com.holems.video.master.parser.dto.VideoInfo;

/**
 * 视频解析器接口
 */
public interface VideoParser {

    VideoInfo parse(String url) throws Exception;

    String getPlatformKey();

    String getPlatformName();
}
