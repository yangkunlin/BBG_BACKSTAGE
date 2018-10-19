package com.bbg.BACKSTAGE.common;

/**
 * Author:  yangkunlin
 * Date:    2018/9/17
 * Domain:  pla.hc10
 */
public class Page {
    //每页显示数量
    private int limit;
    //页码
    private int page;
    //sql语句起始索引
    private int offset;
    //要排序的字段名
    private String sort;
    //排序规则
    private String sortOrder;
    //要搜索的列
    private String searchTarget;
    //要搜索的内容
    private String searchContent;
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getOffset() {
        return offset;
    }
    public void setOffset(int offset) {
        this.offset = offset;
    }
    public String getSort() {
        return sort;
    }
    public void setSort(String sort) {
        this.sort = sort;
    }
    public String getSortOrder() {
        return sortOrder;
    }
    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSearchTarget() {
        return searchTarget;
    }

    public void setSearchTarget(String searchTarget) {
        this.searchTarget = searchTarget;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }
}
