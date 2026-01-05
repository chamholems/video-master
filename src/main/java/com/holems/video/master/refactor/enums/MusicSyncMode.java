package com.holems.video.master.refactor.enums;

import lombok.Getter;

/**
 * 音乐同步方式
 */
@Getter
public enum MusicSyncMode {
    MATCH_TEMPO("匹配节奏"),
    MATCH_DURATION("匹配时长"),
    CROSSFADE("交叉淡化"),
    LOOP_STRETCH("循环拉伸"),
    CUT_TO_BEAT("按节拍剪辑");

    private final String description;

    MusicSyncMode(String description) {
        this.description = description;
    }
}
