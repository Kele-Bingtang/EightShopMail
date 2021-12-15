package com.eight.controller.manage.product;

import com.eight.bean.Page;
import com.eight.bean.ProductComment;
import com.eight.service.manage.product.IMProductCommentService;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/eight/manage/productComment")
public class MProductCommentContoller {

    @Autowired
    private IMProductCommentService mProductCommentService;

    @RequestMapping("/productCommentManage")
    public String ProductCommentManage(){
        return "manage/product/productCommentManage";
    }

    @RequestMapping("/productCommentPage")
    public String ProductCommentPage(){
        return "manage/product/productCommentPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryProductCommentPage")
    @ResponseBody
    public HashMap<String,Object> queryProductCommentPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<ProductComment> ProductCommentPage = mProductCommentService.queryProductCommentPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(ProductCommentPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryProductCommentList")
    @ResponseBody
    public HashMap<String,Object> queryProductCommentList(){
        return ResultMapUtils.listResult(mProductCommentService.queryProductCommentList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addProductComment")
    @ResponseBody
    public HashMap<String,Object> addProductComment(ProductComment productComment){
        int i = mProductCommentService.addProductComment(productComment);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deleteProductComment")
    @ResponseBody
    public HashMap<String,Object> deleteProductComment(ProductComment productComment){
        int i = mProductCommentService.deleteProductComment(productComment);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/modifyProductComment")
    @ResponseBody
    public HashMap<String,Object> modifyPassword(ProductComment productComment){
        int i = mProductCommentService.modifyProductComment(productComment);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryProductCommentById")
    public String queryProductCommentById(int productCommentId,Model model){
        ProductComment productComment = mProductCommentService.queryProductCommentById(productCommentId);
        model.addAttribute("obj", productComment);
        return "manage/product/productCommentPage";
    }
}
