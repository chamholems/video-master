package com.holems.video.master.refactor.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * 其他参数
 */
@Data
@Builder
public class OtherParams {
    private Boolean addProgressBar;    // 增加进度条
    private ProgressBarStyle progressBarStyle; // 进度条样式
    private Boolean changeBasicInfo;   // 修改基础信息
    private Map<String, String> metadata; // 元数据
}
