package com.holems.video.master.parser.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ParseRequest {

    @NotBlank(message = "视频链接不能为空")
    @Pattern(
            regexp = "^.*(https?://.+)|([a-zA-Z0-9:/￥@.\\s]+:/\\S+).*$",
            message = "链接格式不正确（请输入有效链接）"
    )
    private String url;
}
