package com.holems.video.master.refactor.enums;

import lombok.Getter;

/**
 * 时间戳格式
 */
@Getter
public enum TimestampFormat {
    NONE("无"),
    TEXT("文本"),
    IMAGE("图片水印"),
    EMBEDDED("嵌入元数据");

    private final String description;

    TimestampFormat(String description) {
        this.description = description;
    }
}
