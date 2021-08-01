package com.eight.mapper.consume;

import com.eight.bean.BookDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("detailMapper")
public interface BookDetailMapper {
    public List<Class> queryBookDetailBylimitWithCondition(String condition,String sortCon,long m,String pageSize);
    public List<BookDetail> queryAllBookDetail();
    public long queryBookDetailCountWithCondition(String condition);
    public long queryBookDetailCount();
}
