package com.jingjing.manage.param;

/**
 * Created by yuanqingjing on 2018/5/21
 */
public class PageParam {
    Integer page;
    Integer pageSize;
    Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PageParam)) return false;

        PageParam pageParam = (PageParam) o;

        if (page != null ? !page.equals(pageParam.page) : pageParam.page != null) return false;
        return pageSize != null ? pageSize.equals(pageParam.pageSize) : pageParam.pageSize == null;
    }

    @Override
    public int hashCode() {
        int result = page != null ? page.hashCode() : 0;
        result = 31 * result + (pageSize != null ? pageSize.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PageParam{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
