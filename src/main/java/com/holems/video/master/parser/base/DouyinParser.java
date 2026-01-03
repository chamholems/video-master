package com.holems.video.master.parser.base;

import com.fasterxml.jackson.databind.JsonNode;
import com.holems.video.master.common.utils.HttpUtil;
import com.holems.video.master.parser.dto.VideoInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 抖音视频解析器 - 简洁版本
 */
@Slf4j
@Component
public class DouyinParser extends AbstractVideoParser {

    // 平台配置
    @Override
    public String getPlatformKey() { return "douyin"; }
    @Override
    public String getPlatformName() { return "抖音"; }
    @Override
    public String[] getDomainPatterns() {
        return new String[]{
                "douyin\\.com",
                "iesdouyin\\.com",
                "v\\.douyin\\.com"
        };
    }

    // 正则表达式
    private static final Pattern VIDEO_ID_PATTERN = Pattern.compile("/(\\d+)/?");
    private static final Pattern SHORT_CODE_PATTERN = Pattern.compile("v\\.douyin\\.com/(\\w+)");
    private static final Pattern JSON_DATA_PATTERN =
            Pattern.compile("window\\._ROUTER_DATA\\s*=\\s*(.*?)</script>", Pattern.DOTALL);


    // 默认请求头
    private static final Map<String, String> DEFAULT_HEADERS = Map.of(
            "User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0 Mobile/15E148 Safari/604.1",
            "Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"
    );

    @Override
    public String preprocessUrl(String url) {
        if (url == null || url.trim().isEmpty()) {
            return url;
        }

        String processed = url.trim();

        // 1. 首先尝试提取标准HTTP/HTTPS链接
        String httpUrl = extractHttpUrl(processed);
        if (httpUrl != null) {
            return httpUrl;
        }

        // 2. 处理特殊短链接格式（如 Lws:/xxxx）
        Pattern specialPattern = Pattern.compile("([A-Za-z0-9\\s@.￥]+?):(/[^\\s]+)");
        Matcher matcher = specialPattern.matcher(processed);

        if (matcher.find()) {
            String path = matcher.group(2);
            // 清理路径中的空格和特殊字符
            path = path.trim().replaceAll("[\\s\\p{Punct}]+$", "");

            // 构建标准抖音短链接
            String shortLink = "https://v.douyin.com" + path;

            // 进一步处理可能的重复斜杠
            shortLink = shortLink.replaceAll("(?<!https?:)/{2,}", "/");

            log.debug("转换特殊链接: {} -> {}", processed, shortLink);
            return shortLink;
        }

        // 3. 如果已经是v.douyin.com开头的短链接，但被其他文本包围，尝试提取
        Pattern douyinShortPattern = Pattern.compile("https?://v\\.douyin\\.com/[^\\s]+");
        matcher = douyinShortPattern.matcher(processed);

        if (matcher.find()) {
            String foundUrl = matcher.group();
            // 清理URL末尾的标点符号
            foundUrl = foundUrl.replaceAll("[,。\"'!?;:，、\\s]+$", "");
            return foundUrl;
        }

        // 4. 如果没有匹配到任何模式，返回原始值
        return processed;
    }

    /**
     * 从文本中提取HTTP/HTTPS链接
     */
    private String extractHttpUrl(String text) {
        // 匹配http://或https://开头的链接
        Pattern httpPattern = Pattern.compile("(https?://[^\\s]+)");
        Matcher matcher = httpPattern.matcher(text);

        if (matcher.find()) {
            String url = matcher.group(1);

            // 清理URL末尾的常见标点符号和空格
            url = url.replaceAll("[,。\"'!?;:，、\\s]+$", "");

            // 特别处理中文标点
            url = url.replaceAll("，$|。$|？$|！$|；$|：$|、$", "");

            return url;
        }

        return null;
    }

    @Override
    public VideoInfo parse(String url) throws Exception {
        log.info("解析抖音链接: {}", url);

        // 1. 获取最终URL（处理重定向）
        String finalUrl = getFinalUrl(url);

        // 2. 提取视频ID
        String videoId = extractVideoId(finalUrl);
        if (videoId == null) {
            throw new IllegalArgumentException("无法提取视频ID: " + finalUrl);
        }

        // 3. 获取视频数据
        Map<String, Object> videoData = fetchByHtml(videoId);

        // 4. 构建结果
        return buildVideoInfo(videoData, url, videoId);
    }

    /**
     * 获取最终URL（处理重定向）
     */
    private String getFinalUrl(String url) throws Exception {
        return HttpUtil.getRedirectUrl(httpClient, url, DEFAULT_HEADERS);
    }

    /**
     * 提取视频ID
     */
    private String extractVideoId(String url) {
        // 尝试多种格式
        Matcher matcher;

        // 格式1: /video/123456/
        matcher = VIDEO_ID_PATTERN.matcher(url);
        if (matcher.find()) {
            return matcher.group(1);
        }

        // 格式2: v.douyin.com/abc123 → 需要获取重定向后的真实ID
        matcher = SHORT_CODE_PATTERN.matcher(url);
        if (matcher.find()) {
            return null; // 需要进一步处理
        }

        return null;
    }

    /**
     * 通过HTML页面获取数据
     */
    private Map<String, Object> fetchByHtml(String videoId) throws Exception {
        String url = String.format("https://www.iesdouyin.com/share/video/%s/", videoId);
        String html = HttpUtil.get(httpClient, url, DEFAULT_HEADERS);

        // 提取JSON数据
        Matcher matcher = JSON_DATA_PATTERN.matcher(html);
        if (!matcher.find()) {
            throw new RuntimeException("从HTML提取数据失败");
        }

        // 提取并清理JSON字符串
        String jsonStr = matcher.group(1).trim();

        // 处理可能的末尾分号
        if (jsonStr.endsWith(";")) {
            jsonStr = jsonStr.substring(0, jsonStr.length() - 1);
        }

        log.debug("提取到JSON数据长度: {}", jsonStr.length());

        // 解析JSON
        JsonNode data = HttpUtil.parseJson(jsonStr);

        // 按照PHP代码的路径获取数据
        JsonNode loaderData = data.path("loaderData");
        if (loaderData.isMissingNode()) {
            throw new RuntimeException("JSON数据中未找到loaderData");
        }

        JsonNode videoPage = loaderData.path("video_(id)/page");
        if (videoPage.isMissingNode()) {
            throw new RuntimeException("JSON数据中未找到video_(id)/page");
        }

        JsonNode videoInfoRes = videoPage.path("videoInfoRes");
        if (videoInfoRes.isMissingNode()) {
            throw new RuntimeException("JSON数据中未找到videoInfoRes");
        }

        JsonNode itemList = videoInfoRes.path("item_list");
        if (!itemList.isArray() || itemList.isEmpty()) {
            throw new RuntimeException("item_list为空或不是数组");
        }

        JsonNode item = itemList.get(0);
        if (item == null || item.isMissingNode()) {
            throw new RuntimeException("item_list第一个元素为空");
        }

        // 检查是否有video.play_addr.uri
        JsonNode videoNode = item.path("video");
        JsonNode playAddr = videoNode.path("play_addr");
        String videoUri = playAddr.path("uri").asText();

        if (videoUri == null || videoUri.isEmpty()) {
            throw new RuntimeException("未找到视频URI");
        }

        log.debug("成功提取视频URI: {}", videoUri);

        // 转换为Map格式
        return convertHtmlData(item);
    }

    /**
     * 转换HTML数据
     */
    private Map<String, Object> convertHtmlData(JsonNode item) {
        Map<String, Object> data = new HashMap<>();

        // 基础信息
        data.put("id", item.path("aweme_id").asText());
        data.put("title", item.path("desc").asText());

        // 作者信息
        JsonNode author = item.path("author");
        data.put("author", Map.of(
                "name", author.path("nickname").asText(),
                "id", author.path("unique_id").asText(),
                "avatar", Objects.requireNonNull(getFirstUrl(author.path("avatar_medium").path("url_list")))
        ));

        // 视频信息
        JsonNode video = item.path("video");
        String videoUri = video.path("play_addr").path("uri").asText();
        data.put("video", Map.of(
                "url", String.format("https://aweme.snssdk.com/aweme/v1/play/?video_id=%s", videoUri),
                "cover", Objects.requireNonNull(getFirstUrl(video.path("cover").path("url_list"))),
                "duration", video.path("duration").asLong()
        ));

        return data;
    }

    /**
     * 构建 VideoInfo
     */
    private VideoInfo buildVideoInfo(Map<String, Object> data, String originalUrl, String videoId) {
        VideoInfo info = VideoInfo.success(getPlatformKey(), originalUrl);

        // 设置基础信息
        info.setTitle((String) data.get("title"));
        info.setDescription((String) data.get("description"));
        info.setVideoId(videoId);

        // 作者信息
        @SuppressWarnings("unchecked")
        Map<String, Object> author = (Map<String, Object>) data.get("author");
        if (author != null) {
            info.setAuthor((String) author.get("name"));
            info.setAuthorId((String) author.get("id"));
            info.setAuthorAvatar((String) author.get("avatar"));
        }

        // 视频信息
        @SuppressWarnings("unchecked")
        Map<String, Object> video = (Map<String, Object>) data.get("video");
        if (video != null) {
            info.setVideoUrl((String) video.get("url"));
            info.setCoverImage((String) video.get("cover"));
            info.setDuration((Long) video.get("duration"));

            Integer width = (Integer) video.get("width");
            Integer height = (Integer) video.get("height");
            if (width != null) info.setWidth(width);
            if (height != null) info.setHeight(height);
        }

        // 统计信息
        @SuppressWarnings("unchecked")
        Map<String, Object> stats = (Map<String, Object>) data.get("stats");
        if (stats != null) {
            info.setLikeCount((Long) stats.get("likes"));
            info.setCommentCount((Long) stats.get("comments"));
            info.setShareCount((Long) stats.get("shares"));
        }

        // 创建时间
        if (data.get("createTime") instanceof LocalDateTime) {
            info.setCreateTime((LocalDateTime) data.get("createTime"));
        }

        return info;
    }

    /**
     * 获取URL列表中的第一个
     */
    private String getFirstUrl(JsonNode urlList) {
        if (urlList.isArray() && !urlList.isEmpty()) {
            String url = urlList.get(0).asText();
            return fixUrl(url);
        }
        return null;
    }

    /**
     * 修复URL
     */
    private String fixUrl(String url) {
        if (url == null) return null;
        if (url.startsWith("//")) return "https:" + url;
        if (!url.startsWith("http")) return "https://" + url;
        return url;
    }
}