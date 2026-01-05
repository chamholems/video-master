package com.holems.video.master.refactor.dto.result;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VideoProcessResult {
    private String processedVideoPath;
    private Integer width;
    private Integer height;
    private Double duration;
    private Integer frameRate;
}
