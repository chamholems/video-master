package com.holems.video.master.refactor.dto.result;

import com.holems.video.master.refactor.dto.SubtitleItem;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SubtitleProcessResult {
    private String subtitleFilePath;
    private List<SubtitleItem> subtitles;
}
