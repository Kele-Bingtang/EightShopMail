package com.eight.service.manage.product;

import com.eight.bean.Page;
import com.eight.bean.BookDetail;
import com.eight.bean.ProductInfo;

import java.util.List;

public interface IMBookDetailService {

    /**
     * 通过用户地址名查询用户地址
     * @param bookDetail 用户地址
     * @return 用户地址
     */
    public BookDetail queryBookDetailByUsername(BookDetail bookDetail);

    /**
     * 查询所有用户地址
     * @return 用户地址
     */
    public List<BookDetail> queryBookDetailList();

    /**
     * 添加用户地址
     * @param bookDetail 用户地址
     * @return 受影响的行数
     */
    public int addBookDetail(BookDetail bookDetail);
    /**
     * 删除用户地址
     * @param bookDetail 用户地址
     * @return 受影响的行数
     */
    public int deleteBookDetail(BookDetail bookDetail);
    /**
     * 修改用户地址
     * @param bookDetail 用户地址
     * @return 受影响的行数
     */
    public int modifyBookDetail(BookDetail bookDetail);

    /**
     * 分页查询
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<BookDetail> queryBookDetailPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据用户地址id查询用户地址
     * @param bookDetailId 用户地址id
     * @return 用户地址
     */
    BookDetail queryBookDetailById(Integer bookDetailId);

    public List<ProductInfo> queryProductInfoList();

    public List<ProductInfo> queryProductInfoByCategory(Integer categoryId);
}
