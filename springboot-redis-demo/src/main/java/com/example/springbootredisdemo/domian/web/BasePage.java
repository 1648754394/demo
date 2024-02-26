package com.example.springbootredisdemo.domian.web;

import java.io.Serializable;

public class BasePage implements Serializable {


    private Integer pageIndex = 1;


    private Integer pageSize = 20;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }




}
