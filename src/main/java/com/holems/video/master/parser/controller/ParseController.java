package com.holems.video.master.parser.controller;

import com.holems.video.master.common.response.ApiResponse;
import com.holems.video.master.common.response.ResponseCode;
import com.holems.video.master.common.response.ResponseUtil;
import com.holems.video.master.parser.dto.ParseRequest;
import com.holems.video.master.parser.dto.VideoInfo;
import com.holems.video.master.parser.service.VideoParserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/parser")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ParseController {

    private final VideoParserService videoParserService;

    @GetMapping("test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello World");
    }


    /**
     * 解析单个视频
     */
    @PostMapping("/parse")
    public ApiResponse<VideoInfo> parseVideo(@Valid @RequestBody ParseRequest request) {
        VideoInfo videoInfo = videoParserService.parse(request.getUrl());

        if (videoInfo.getSuccess()) {
            return ResponseUtil.success(videoInfo, "视频解析成功");
        } else {
            return ResponseUtil.error(
                    ResponseCode.VIDEO_PARSE_ERROR.getCode(),
                    videoInfo.getErrorMessage(),
                    videoInfo
            );
        }
    }

    /**
     * GET 方式解析
     */
    @GetMapping("/parse")
    public ResponseEntity<VideoInfo> parseVideoByGet(@RequestParam String url) {
        VideoInfo result = videoParserService.parse(url);
        return ResponseEntity.ok(result);
    }

    /**
     * 批量解析
     */
    @PostMapping("/batch")
    public ResponseEntity<Map<String, VideoInfo>> batchParse(
            @RequestBody Map<String, String> urlMap) {

        Map<String, VideoInfo> results = new HashMap<>();
        urlMap.forEach((key, url) -> {
            VideoInfo info = videoParserService.parse(url);
            results.put(key, info);
        });

        return ResponseEntity.ok(results);
    }

    /**
     * 获取支持的平台
     */
    @GetMapping("/platforms")
    public ResponseEntity<Map<String, String>> getSupportedPlatforms() {
        return ResponseEntity.ok(videoParserService.getSupportedPlatforms());
    }

    /**
     * 检查 URL 是否支持
     */
    @GetMapping("/check")
    public ResponseEntity<Map<String, Object>> checkUrl(@RequestParam String url) {
        boolean supported = videoParserService.isSupported(url);
        String platform = videoParserService.getSupportedPlatforms().entrySet().stream()
                .filter(entry -> url.contains(entry.getKey()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);

        Map<String, Object> result = new HashMap<>();
        result.put("supported", supported);
        result.put("platform", platform);
        result.put("url", url);

        return ResponseEntity.ok(result);
    }

}
