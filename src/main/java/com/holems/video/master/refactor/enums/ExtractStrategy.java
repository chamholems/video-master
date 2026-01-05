package com.holems.video.master.refactor.enums;

import lombok.Getter;

/**
 * 抽取策略枚举
 */
@Getter
public enum ExtractStrategy {
    FIXED_INTERVAL("固定间隔"),
    SCENE_CHANGE("场景变化"),
    KEY_FRAME("关键帧"),
    MANUAL("手动选择"),
    RANDOM("随机抽取"),
    UNIFORM("均匀分布");

    private final String description;

    ExtractStrategy(String description) {
        this.description = description;
    }
}

