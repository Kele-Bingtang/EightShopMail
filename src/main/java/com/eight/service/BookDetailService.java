package com.eight.service;

import com.eight.bean.BookDetail;

import java.util.List;

public interface BookDetailService {
    public List<Class> queryBookDetailBylimitWithCondition(String condition,String sortCon,long m,String pageSize);
    public List<BookDetail> queryAllBookDetail();
    public long queryBookDetailCountWithCondition(String condition);
    public long queryBookDetailCount();
}
