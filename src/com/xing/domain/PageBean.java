package com.xing.domain;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public class PageBean<T> {
    /**当前页码*/
    private int pageCode;
    /**总记录数*/
    private int totalRecode;
    /**每页记录数*/
    private int pageSize;
    /**当前页记录数据*/
    private List<T> beanlist;
    /**url后面的条件*/
    private String url;

    @Override
    public String toString() {
        return "PageBean{" +
                "pageCode=" + pageCode +
                ", totalRecode=" + totalRecode +
                ", pageSize=" + pageSize +
                ", beanlist=" + beanlist +
                ", url='" + url + '\'' +
                '}';
    }

    /**
     * 计算总页码数
     */
    public int getTotalPage(){
        if((totalRecode%pageSize) == 0){
            return totalRecode/pageSize;
        }
        return totalRecode/pageSize + 1;
    }

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public int getTotalRecode() {
        return totalRecode;
    }

    public void setTotalRecode(int totalRecode) {
        this.totalRecode = totalRecode;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getBeanlist() {
        return beanlist;
    }

    public void setBeanlist(List<T> beanlist) {
        this.beanlist = beanlist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
