package com.eight.bean;

import java.util.List;

public class Page<T> {
    public static final Integer PAGE_SIZE = 4;
    //当前页
    private Integer currentNum;
    //总页数
    private Integer totalPageNum;
    //总数据
    private Integer totalPageCount;
    //一页多少数据
    private Integer singlePageSize = PAGE_SIZE;
    //当前页的数据起始点
    private Integer startIndex;
    //当前页的数据
    private List<T> item;

    public Page() {
    }

    public Page(Integer currentNum, Integer totalPageNum, Integer totalPageCount, Integer singlePageSize, List<T> item) {
        this.currentNum = currentNum;
        this.totalPageNum = totalPageNum;
        this.totalPageCount = totalPageCount;
        this.singlePageSize = singlePageSize;
        this.item = item;
    }

    public Page(Integer currentNum, Integer singlePageSize) {
        this.currentNum = currentNum;
        this.singlePageSize = singlePageSize;
        this.startIndex = (currentNum - 1) * singlePageSize;
    }

    public static Integer getPageSize() {
        return PAGE_SIZE;
    }

    public Integer getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(Integer currentNum) {
        this.currentNum = currentNum;
    }

    public Integer getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(Integer totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public Integer getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(Integer totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public Integer getSinglePageSize() {
        return singlePageSize;
    }

    public void setSinglePageSize(Integer singlePageSize) {
        this.singlePageSize = singlePageSize;
    }

    public List<T> getItem() {
        return item;
    }

    public void setItem(List<T> item) {
        this.item = item;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentNum=" + currentNum +
                ", totalPageNum=" + totalPageNum +
                ", totalPageCount=" + totalPageCount +
                ", singlePageSize=" + singlePageSize +
                ", startIndex=" + startIndex +
                ", item=" + item +
                '}';
    }
}
