package com.eight.service.manage.product.impl;

import com.eight.bean.Page;
import com.eight.bean.HourseAppDetail;
import com.eight.bean.ProductInfo;
import com.eight.mapper.manage.product.MHourseAppDetailMapper;
import com.eight.service.manage.product.IMHourseAppDetailService;
import com.eight.service.manage.product.IMProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service("mHourseAppDetailServiceImpl")
public class MHourseAppDetailServiceImpl implements IMHourseAppDetailService {
    @Autowired
    private MHourseAppDetailMapper mHourseAppDetailMapper;
    @Autowired
    private IMProductInfoService mProductInfoService;
    @Override
    public HourseAppDetail queryHourseAppDetailByUsername(HourseAppDetail hourseAppDetail) {
        return mHourseAppDetailMapper.queryHourseAppDetailByUsername(hourseAppDetail);
    }

    @Override
    public List<HourseAppDetail> queryHourseAppDetailList() {
        return mHourseAppDetailMapper.queryHourseAppDetailList();
    }

    @Override
    public int addHourseAppDetail(HourseAppDetail hourseAppDetail) {
        nullToNum(hourseAppDetail);
        return mHourseAppDetailMapper.addHourseAppDetail(hourseAppDetail);
    }

    @Override
    public int deleteHourseAppDetail(HourseAppDetail hourseAppDetail) {
        return mHourseAppDetailMapper.deleteHourseAppDetail(hourseAppDetail);
    }

    @Override
    public int modifyHourseAppDetail(HourseAppDetail hourseAppDetail) {
        nullToNum(hourseAppDetail);
        return mHourseAppDetailMapper.modifyHourseAppDetail(hourseAppDetail);
    }

    @Override
    public Page<HourseAppDetail> queryHourseAppDetailPage(int currentNum, int singlePageSize, String param) {
        Page<HourseAppDetail> hourseAppDetailPage = new Page<>(currentNum,singlePageSize);
        List<HourseAppDetail> hourseAppDetailItem = mHourseAppDetailMapper.queryHourseAppDetailPage(hourseAppDetailPage, param);
        hourseAppDetailPage.setItem(hourseAppDetailItem);
        hourseAppDetailPage.setTotalPageCount(mHourseAppDetailMapper.queryHourseAppDetailCount());
        return hourseAppDetailPage;
    }

    @Override
    public HourseAppDetail queryHourseAppDetailById(Integer hourseAppDetailId) {
        return mHourseAppDetailMapper.queryHourseAppDetailById(hourseAppDetailId);
    }

    @Override
    public List<ProductInfo> queryProductInfoList() {
        return mProductInfoService.queryProductInfoList();
    }

    @Override
    public List<ProductInfo> queryProductInfoByCategory(Integer categoryId) {
        return mProductInfoService.queryProductInfoByCategory(categoryId);
    }

    public void nullToNum(HourseAppDetail hourseAppDetail){
        if(hourseAppDetail.gethWeight() == null){
            hourseAppDetail.sethWeight(new BigDecimal(0));
        }
        if(hourseAppDetail.gethHeight() == null){
            hourseAppDetail.sethHeight(new BigDecimal(0));
        }
        if(hourseAppDetail.gethWidth() == null){
            hourseAppDetail.sethWidth(new BigDecimal(0));
        }
    }
}
