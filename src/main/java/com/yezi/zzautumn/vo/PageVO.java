package com.yezi.zzautumn.vo;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: yezi
 * @Date: 2019/1/19 10 19
 * @Description:
 */
public class PageVO {

    private Integer pageIndex;
    private Integer pageSize;
    private Long count;
    private Integer pageCount;
    private List<?> content;

    public PageVO() { super(); }

    public PageVO(Integer pageIndex, Integer pageSize, Long count, Integer pageCount, List<?> content) {
        super();
        this.pageIndex = pageIndex;
        this.pageCount = pageCount;
        this.count = count;
        this.pageSize = pageSize;
        this.content = content;
    }

    public static <T> PageVO make(Page<T> page) {
        PageVO pageVO = new PageVO();
        if (null != page && !page.isEmpty()) {
            pageVO.setCount(page.getTotalElements());
            pageVO.setPageIndex(page.getNumber());
            pageVO.setPageCount(page.getTotalPages());
            pageVO.setContent(page.getContent());
            pageVO.setPageSize(page.getSize());
        }

        return pageVO;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        if (null != pageIndex) {
            return pageIndex + 1;
        } else {
            return 1;
        }
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<?> getContent() {
        return content;
    }

    public void setContent(List<?> content) {
        this.content = content;
    }
}
