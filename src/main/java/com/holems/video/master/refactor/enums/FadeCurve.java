package com.holems.video.master.refactor.enums;

import lombok.Getter;

/**
 * 淡入淡出曲线
 */
@Getter
public enum FadeCurve {
    LINEAR("线性"),
    EXPONENTIAL("指数"),
    LOGARITHMIC("对数"),
    S_CURVE("S型"),
    COSINE("余弦");

    private final String description;

    FadeCurve(String description) {
        this.description = description;
    }
}
