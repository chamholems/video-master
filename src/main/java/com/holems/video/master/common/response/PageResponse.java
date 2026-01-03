package com.holems.video.master.common.response;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 统一分页响应体
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 当前页
     */
    private Long current;

    /**
     * 每页大小
     */
    private Long size;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 总页数
     */
    private Long pages;

    /**
     * 数据列表
     */
    private List<T> records;

    /**
     * 是否有上一页
     */
    private Boolean hasPrevious;

    /**
     * 是否有下一页
     */
    private Boolean hasNext;

    /**
     * 从 MyBatis Plus 的 IPage 转换
     */
    public static <T> PageResponse<T> from(IPage<T> page) {
        if (page == null) {
            return PageResponse.<T>builder()
                    .current(1L)
                    .size(10L)
                    .total(0L)
                    .pages(0L)
                    .build();
        }

        return PageResponse.<T>builder()
                .current(page.getCurrent())
                .size(page.getSize())
                .total(page.getTotal())
                .pages(page.getPages())
                .records(page.getRecords())
                .hasPrevious(page.getCurrent() > 1)
                .hasNext(page.getCurrent() < page.getPages())
                .build();
    }

    /**
     * 从列表创建分页响应
     */
    public static <T> PageResponse<T> of(List<T> records, Long current, Long size, Long total) {
        long pages = total > 0 ? (total + size - 1) / size : 0;

        return PageResponse.<T>builder()
                .current(current)
                .size(size)
                .total(total)
                .pages(pages)
                .records(records)
                .hasPrevious(current > 1)
                .hasNext(current < pages)
                .build();
    }
}
