package com.holems.video.master.refactor.dto.result;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AudioProcessResult {
    private String processedAudioPath;
    private Double duration;
    private String format;
}
