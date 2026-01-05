package com.holems.video.master.refactor.enums;

import lombok.Getter;

/**
 * 混音算法枚举
 */
@Getter
public enum MixAlgorithm {
    LINEAR("线性混合"),
    PARALLEL("平行混合"),
    SERIAL("串行混合"),
    SIDE_CHAIN("侧链压缩"),
    ADAPTIVE("自适应混合");

    private final String description;

    MixAlgorithm(String description) {
        this.description = description;
    }
}
