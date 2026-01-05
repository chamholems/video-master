package com.holems.video.master.refactor.controller;

import com.holems.video.master.common.response.ApiResponse;
import com.holems.video.master.common.response.ResponseUtil;
import com.holems.video.master.refactor.dto.VideoCreationRequest;
import com.holems.video.master.refactor.dto.result.CreationResult;
import com.holems.video.master.refactor.service.VideoRefactorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * 视频二创控制器
 */
@Slf4j
@RestController
@RequestMapping("/refactor")
@RequiredArgsConstructor
public class VideoRefactorController {

    private final VideoRefactorService refactorService;

    /**
     * 创建二创视频
     */
    @PostMapping("/create")
    public CompletableFuture<ApiResponse<Map<String, Object>>> createVideo(
            @RequestBody VideoCreationRequest request) {

        return refactorService.createVideo(request)
                .thenApply(result -> {
                    if (result.getSuccess()) {
                        return ApiResponse.success(Map.of(
                                "success", true,
                                "data", Map.of(
                                        "videoUrl", result.getVideoUrl(),
                                        "duration", result.getDuration(),
                                        "size", result.getSize()
                                ),
                                "message", "视频创建成功"
                        ));
                    } else {
                        return ApiResponse.error(result.getErrorMessage());
                    }
                });
    }

    /**
     * 批量创建
     */
    @PostMapping("/batch-create")
    public CompletableFuture<ApiResponse<Map<String, Object>>> batchCreate(
            @RequestBody List<VideoCreationRequest> requests) {

        return refactorService.batchCreate(requests)
                .thenApply(results -> {
                    long successCount = results.stream()
                            .filter(CreationResult::getSuccess)
                            .count();

                    return ApiResponse.success(Map.of(
                            "success", true,
                            "data", Map.of(
                                    "total", requests.size(),
                                    "success", successCount,
                                    "failed", requests.size() - successCount,
                                    "results", results
                            )
                    ));
                });
    }

    /**
     * 获取支持的格式
     */
    @GetMapping("/formats")
    public ApiResponse<List<String>> getSupportedFormats() {
        List<String> formats = refactorService.getSupportedFormats();
        return ResponseUtil.success(formats);
    }

    /**
     * 获取支持的分辨率
     */
    @GetMapping("/resolutions")
    public ApiResponse<List<String>> getSupportedResolutions() {
        List<String> resolutions = refactorService.getSupportedResolutions();
        return ResponseUtil.success(resolutions);
    }

    /**
     * 健康检查
     */
    @GetMapping("/health")
    public ApiResponse<Map<String, Object>> healthCheck() {
        return ApiResponse.success(Map.of(
                "status", "UP",
                "service", "video-creator",
                "timestamp", System.currentTimeMillis()
        ));
    }
}
