package com.zhangjingwen.common.response;

import com.github.pagehelper.Page;

import java.util.List;

public class DataPageResult<T> extends ResponseResult {

    private int pageStart;
    private int pageSize;
    private long total;
    private int totalPage;

    private List<T> data;

    public DataPageResult(ResultCode resultCode, Page page) {
        super(resultCode);
        this.pageStart = page.getPageNum();
        this.pageSize = page.getPageSize();
        this.total = page.getTotal();
        this.totalPage = page.getPages();
        this.data = page.getResult();
    }

    public DataPageResult(ResultCode resultCode, Page page, List<T> data) {
        super(resultCode);
        this.pageStart = page.getPageNum();
        this.pageSize = page.getPageSize();
        this.total = page.getTotal();
        this.totalPage = page.getPages();
        this.data = data;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
