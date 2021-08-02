package com.eight.controller.manage.product;

import com.eight.bean.Page;
import com.eight.bean.BookDetail;
import com.eight.service.manage.product.IMBookDetailService;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/eight/manage/bookDetail")
public class MBookDetailContoller {

    @Autowired
    private IMBookDetailService mBookDetailService;

    @RequestMapping("/bookDetailManage")
    public String BookDetailManage(){
        return "/manage/product/bookDetailManage";
    }

    @RequestMapping("/bookDetailPage")
    public String BookDetailPage(Integer categoryId,Model model){
        model.addAttribute("products", mBookDetailService.queryProductInfoByCategory(categoryId));
        return "/manage/product/bookDetailPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryBookDetailPage")
    @ResponseBody
    public HashMap<String,Object> queryBookDetailPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<BookDetail> BookDetailPage = mBookDetailService.queryBookDetailPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(BookDetailPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryBookDetailList")
    @ResponseBody
    public HashMap<String,Object> queryBookDetailList(){
        return ResultMapUtils.listResult(mBookDetailService.queryBookDetailList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addBookDetail")
    @ResponseBody
    public HashMap<String,Object> addBookDetail(BookDetail bookDetail){
        int i = mBookDetailService.addBookDetail(bookDetail);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deleteBookDetail")
    @ResponseBody
    public HashMap<String,Object> deleteBookDetail(BookDetail bookDetail){
        int i = mBookDetailService.deleteBookDetail(bookDetail);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/modifyBookDetail")
    @ResponseBody
    public HashMap<String,Object> modifyPassword(BookDetail bookDetail){
        int i = mBookDetailService.modifyBookDetail(bookDetail);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryBookDetailById")
    public String queryBookDetailById(Integer bDetailId,Integer categoryId,Model model){
        BookDetail bookDetail = mBookDetailService.queryBookDetailById(bDetailId);
        model.addAttribute("obj", bookDetail);
        model.addAttribute("products", mBookDetailService.queryProductInfoByCategory(categoryId));
        return "manage/product/bookDetailPage";
    }
}
