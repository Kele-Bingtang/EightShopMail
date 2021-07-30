package com.eight.service.manage.product.impl;

import com.eight.bean.Page;
import com.eight.bean.ProductComment;
import com.eight.mapper.manage.product.MProductCommentMapper;
import com.eight.service.manage.product.IMProductCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mProductCommentServiceImpl")
public class MProductCommentServiceImpl implements IMProductCommentService {
    @Autowired
    private MProductCommentMapper mProductCommentMapper;
    @Override
    public ProductComment queryProductCommentByUsername(ProductComment productComment) {
        return mProductCommentMapper.queryProductCommentByUsername(productComment);
    }

    @Override
    public List<ProductComment> queryProductCommentList() {
        return mProductCommentMapper.queryProductCommentList();
    }

    @Override
    public int addProductComment(ProductComment productComment) {
        return mProductCommentMapper.addProductComment(productComment);
    }

    @Override
    public int deleteProductComment(ProductComment productComment) {
        return mProductCommentMapper.deleteProductComment(productComment);
    }

    @Override
    public int modifyProductComment(ProductComment productComment) {
        return mProductCommentMapper.modifyProductComment(productComment);
    }

    @Override
    public Page<ProductComment> queryProductCommentPage(int currentNum, int singlePageSize, String param) {
        Page<ProductComment> productCommentPage = new Page<>(currentNum,singlePageSize);
        List<ProductComment> productCommentItem = mProductCommentMapper.queryProductCommentPage(productCommentPage, param);
        productCommentPage.setItem(productCommentItem);
        productCommentPage.setTotalPageCount(mProductCommentMapper.queryProductCommentCount());
        return productCommentPage;
    }

    @Override
    public ProductComment queryProductCommentById(Integer productCommentId) {
        return mProductCommentMapper.queryProductCommentById(productCommentId);
    }
}
