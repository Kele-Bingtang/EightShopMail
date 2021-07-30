package com.eight.service.manage.product.impl;

import com.eight.bean.Page;
import com.eight.bean.BookDetail;
import com.eight.bean.ProductInfo;
import com.eight.mapper.manage.product.MBookDetailMapper;
import com.eight.service.manage.product.IMBookDetailService;
import com.eight.service.manage.product.IMProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mBookDetailServiceImpl")
public class MBookDetailServiceImpl implements IMBookDetailService {
    @Autowired
    private MBookDetailMapper mBookDetailMapper;
    @Autowired
    private IMProductInfoService mProductInfoService;
    @Override
    public BookDetail queryBookDetailByUsername(BookDetail bookDetail) {
        return mBookDetailMapper.queryBookDetailByUsername(bookDetail);
    }

    @Override
    public List<BookDetail> queryBookDetailList() {
        return mBookDetailMapper.queryBookDetailList();
    }

    @Override
    public int addBookDetail(BookDetail bookDetail) {
        return mBookDetailMapper.addBookDetail(bookDetail);
    }

    @Override
    public int deleteBookDetail(BookDetail bookDetail) {
        return mBookDetailMapper.deleteBookDetail(bookDetail);
    }

    @Override
    public int modifyBookDetail(BookDetail bookDetail) {
        return mBookDetailMapper.modifyBookDetail(bookDetail);
    }

    @Override
    public Page<BookDetail> queryBookDetailPage(int currentNum, int singlePageSize, String param) {
        Page<BookDetail> bookDetailPage = new Page<>(currentNum,singlePageSize);
        List<BookDetail> bookDetailItem = mBookDetailMapper.queryBookDetailPage(bookDetailPage, param);
        bookDetailPage.setItem(bookDetailItem);
        bookDetailPage.setTotalPageCount(mBookDetailMapper.queryBookDetailCount());
        return bookDetailPage;
    }

    @Override
    public BookDetail queryBookDetailById(Integer bookDetailId) {
        return mBookDetailMapper.queryBookDetailById(bookDetailId);
    }

    @Override
    public List<ProductInfo> queryProductInfoList() {
        return mProductInfoService.queryProductInfoList();
    }

    @Override
    public List<ProductInfo> queryProductInfoByCategory(Integer categoryId) {
        return mProductInfoService.queryProductInfoByCategory(categoryId);
    }
}
