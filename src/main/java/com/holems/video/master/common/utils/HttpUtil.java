package com.holems.video.master.common.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * HTTP工具类
 */
@Component
public class HttpUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 发送GET请求
     */
    public static String get(OkHttpClient client, String url, Map<String, String> headers) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .headers(Headers.of(headers))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("请求失败: " + response.code());
            }
            return response.body().string();
        }
    }

    /**
     * 获取重定向URL
     */
    public static String getRedirectUrl(OkHttpClient client, String url, Map<String, String> headers) throws IOException {
        OkHttpClient noRedirectClient = client.newBuilder()
                .followRedirects(false)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .head()
                .headers(Headers.of(headers))
                .build();

        try (Response response = noRedirectClient.newCall(request).execute()) {
            if (response.isRedirect()) {
                return response.header("Location", url);
            }
            return url;
        }
    }

    /**
     * 解析JSON
     */
    public static JsonNode parseJson(String json) throws IOException {
        return objectMapper.readTree(json);
    }
}
