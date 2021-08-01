package com.eight.service.Impl;

import com.eight.bean.BookDetail;
import com.eight.mapper.BookDetailMapper;
import com.eight.service.BookDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookDetailService")
public class BookDetailServiceImpl implements BookDetailService {
    @Autowired
    BookDetailMapper bookDetailMapper;
    @Override
    public List<Class> queryBookDetailBylimitWithCondition(String condition, String sortCon, long m, String pageSize) {
        return bookDetailMapper.queryBookDetailBylimitWithCondition(condition, sortCon, m, pageSize);
    }

    @Override
    public List<BookDetail> queryAllBookDetail() {
        return bookDetailMapper.queryAllBookDetail();
    }

    @Override
    public long queryBookDetailCountWithCondition(String condition) {
        return bookDetailMapper.queryBookDetailCountWithCondition(condition);
    }

    @Override
    public long queryBookDetailCount() {
        return bookDetailMapper.queryBookDetailCount();
    }
}
