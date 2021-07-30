package com.eight.service.manage.product;

import com.eight.bean.Page;
import com.eight.bean.ProductComment;

import java.util.List;

public interface IMProductCommentService {

    /**
     * 通过用户地址名查询用户地址
     * @param productComment 用户地址
     * @return 用户地址
     */
    public ProductComment queryProductCommentByUsername(ProductComment productComment);

    /**
     * 查询所有用户地址
     * @return 用户地址
     */
    public List<ProductComment> queryProductCommentList();

    /**
     * 添加用户地址
     * @param productComment 用户地址
     * @return 受影响的行数
     */
    public int addProductComment(ProductComment productComment);
    /**
     * 删除用户地址
     * @param productComment 用户地址
     * @return 受影响的行数
     */
    public int deleteProductComment(ProductComment productComment);
    /**
     * 修改用户地址
     * @param productComment 用户地址
     * @return 受影响的行数
     */
    public int modifyProductComment(ProductComment productComment);

    /**
     * 分页查询
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<ProductComment> queryProductCommentPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据用户地址id查询用户地址
     * @param productCommentId 用户地址id
     * @return 用户地址
     */
    ProductComment queryProductCommentById(Integer productCommentId);
}
