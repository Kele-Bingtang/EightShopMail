package com.eight.service.manage.product.impl;

import com.eight.bean.Page;
import com.eight.bean.PhoneDetail;
import com.eight.bean.ProductInfo;
import com.eight.mapper.manage.product.MPhoneDetailMapper;
import com.eight.service.manage.product.IMPhoneDetailService;
import com.eight.service.manage.product.IMProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service("mPhoneDetailServiceImpl")
public class MPhoneDetailServiceImpl implements IMPhoneDetailService {
    @Autowired
    private MPhoneDetailMapper mPhoneDetailMapper;
    @Autowired
    private IMProductInfoService mProductInfoService;
    @Override
    public PhoneDetail queryPhoneDetailByUsername(PhoneDetail phoneDetail) {
        return mPhoneDetailMapper.queryPhoneDetailByUsername(phoneDetail);
    }

    @Override
    public List<PhoneDetail> queryPhoneDetailList() {
        return mPhoneDetailMapper.queryPhoneDetailList();
    }

    @Override
    public int addPhoneDetail(PhoneDetail phoneDetail) {
        nullToNum(phoneDetail);
        return mPhoneDetailMapper.addPhoneDetail(phoneDetail);
    }

    @Override
    public int deletePhoneDetail(PhoneDetail phoneDetail) {
        return mPhoneDetailMapper.deletePhoneDetail(phoneDetail);
    }

    @Override
    public int modifyPhoneDetail(PhoneDetail phoneDetail) {
        nullToNum(phoneDetail);
        return mPhoneDetailMapper.modifyPhoneDetail(phoneDetail);
    }

    @Override
    public Page<PhoneDetail> queryPhoneDetailPage(int currentNum, int singlePageSize, String param) {
        Page<PhoneDetail> phoneDetailPage = new Page<>(currentNum,singlePageSize);
        List<PhoneDetail> phoneDetailItem = mPhoneDetailMapper.queryPhoneDetailPage(phoneDetailPage, param);
        phoneDetailPage.setItem(phoneDetailItem);
        phoneDetailPage.setTotalPageCount(mPhoneDetailMapper.queryPhoneDetailCount());
        return phoneDetailPage;
    }

    @Override
    public PhoneDetail queryPhoneDetailById(Integer phoneDetailId) {
        return mPhoneDetailMapper.queryPhoneDetailById(phoneDetailId);
    }

    @Override
    public List<ProductInfo> queryProductInfoList() {
        return mProductInfoService.queryProductInfoList();
    }

    @Override
    public List<ProductInfo> queryProductInfoByCategory(Integer categoryId) {
        return mProductInfoService.queryProductInfoByCategory(categoryId);
    }

    public void nullToNum(PhoneDetail phoneDetail){
        if(phoneDetail.getpWeight() == null){
            phoneDetail.setpWeight(new BigDecimal(0));
        }
        if(phoneDetail.getpHeight() == null){
            phoneDetail.setpHeight(new BigDecimal(0));
        }
        if(phoneDetail.getpWidth() == null){
            phoneDetail.setpWidth(new BigDecimal(0));
        }
        if(phoneDetail.getpSize() == null){
            phoneDetail.setpSize(new BigDecimal(0));
        }
        if(phoneDetail.getpMeal() == null || phoneDetail.getpMeal().equals("")){
            phoneDetail.setpMeal("标准版");
        }
        if(phoneDetail.getpVersion() == null || phoneDetail.getpVersion().equals("")){
            phoneDetail.setpVersion("官方标配");
        }
    }
}
