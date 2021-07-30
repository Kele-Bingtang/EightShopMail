package com.eight.mapper.manage.product;

import com.eight.bean.Page;
import com.eight.bean.BookDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mBookDetailMapper")
public interface MBookDetailMapper {

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
     * @param bookDetailPage 页数bean
     * @param param 模糊查询
     * @return 用户结果集
     */
    public List<BookDetail> queryBookDetailPage(@Param("bookDetailPage") Page<BookDetail> bookDetailPage, @Param("param") String param);

    /**
     * 根据用户地址id查询用户地址
     * @param bookDetailId 用户地址id
     * @return 用户地址
     */
    BookDetail queryBookDetailById(Integer bookDetailId);

    /**
     * 查询全部数据的总数
     * @return 总数
     */
    public int queryBookDetailCount();
}
