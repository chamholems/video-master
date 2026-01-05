package com.holems.video.master.refactor.enums;

import lombok.Getter;

/**
 * 颜色滤镜枚举
 */
@Getter
public enum ColorFilter {
    NONE("无滤镜"),
    VINTAGE("复古"),
    CINEMATIC("电影"),
    WARM("暖色"),
    COOL("冷色"),
    BLACK_WHITE("黑白"),
    SEPIA("棕褐色"),
    NOSTALGIA("怀旧"),
    VIVID("鲜艳"),
    DREAMY("梦幻"),
    DRAMA("戏剧"),
    SUNSET("日落"),
    MOODY("情绪"),
    PORTRAIT("人像"),
    LANDSCAPE("风景"),
    FOOD("美食"),
    NIGHT("夜景");

    private final String description;

    ColorFilter(String description) {
        this.description = description;
    }
}
