package com.eight.mapper.manage.product;

import com.eight.bean.Page;
import com.eight.bean.ProductComment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mProductCommentMapper")
public interface MProductCommentMapper {

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
     * @param productCommentPage 页数bean
     * @param param 模糊查询
     * @return 用户结果集
     */
    public List<ProductComment> queryProductCommentPage(@Param("productCommentPage") Page<ProductComment> productCommentPage, @Param("param") String param);

    /**
     * 根据用户地址id查询用户地址
     * @param productCommentId 用户地址id
     * @return 用户地址
     */
    ProductComment queryProductCommentById(Integer productCommentId);

    /**
     * 查询全部数据的总数
     * @return 总数
     */
    public int queryProductCommentCount();
}
