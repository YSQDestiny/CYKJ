package com.cykj.service.base.bean;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/7/18 9:23.
 */
public class Page {

    private Integer id;

    private Integer page = 1;

    private Integer rows = 15;

    //总页数
    private long pagerSize;

    //总数
    private long total;

    private List<?> list;

    private String sort;

    private String order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public long getPagerSize() {
        return pagerSize;
    }

    public void setPagerSize(long pagerSize) {
        this.pagerSize = pagerSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
