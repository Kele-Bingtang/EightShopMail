package com.eight.controller.manage.product;

import com.eight.bean.Page;
import com.eight.bean.ProductCategory;
import com.eight.service.manage.product.IMProductCategoryService;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/eight/manage/productCategory")
public class MProductCategoryContoller {

    @Autowired
    private IMProductCategoryService mProductCategoryService;

    @RequestMapping("/productCategoryManage")
    public String ProductCategoryManage(){
        return "manage/product/productCategoryManage";
    }

    @RequestMapping("/productCategoryPage")
    public String ProductCategoryPage(){
        return "manage/product/productCategoryPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryProductCategoryPage")
    @ResponseBody
    public HashMap<String,Object> queryProductCategoryPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<ProductCategory> ProductCategoryPage = mProductCategoryService.queryProductCategoryPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(ProductCategoryPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryProductCategoryList")
    @ResponseBody
    public HashMap<String,Object> queryProductCategoryList(){
        return ResultMapUtils.listResult(mProductCategoryService.queryProductCategoryList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addProductCategory")
    @ResponseBody
    public HashMap<String,Object> addProductCategory(ProductCategory productCategory){
        int i = mProductCategoryService.addProductCategory(productCategory);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deleteProductCategory")
    @ResponseBody
    public HashMap<String,Object> deleteProductCategory(ProductCategory productCategory){
        int i = mProductCategoryService.deleteProductCategory(productCategory);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/modifyProductCategory")
    @ResponseBody
    public HashMap<String,Object> modifyProductCategory(ProductCategory productCategory){
        int i = mProductCategoryService.modifyProductCategory(productCategory);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryProductCategoryById")
    public String queryProductCategoryById(Integer productCategoryId,Model model){
        ProductCategory productCategory = mProductCategoryService.queryProductCategoryById(productCategoryId);
        model.addAttribute("obj", productCategory);
        return "manage/product/productCategoryPage";
    }
}
