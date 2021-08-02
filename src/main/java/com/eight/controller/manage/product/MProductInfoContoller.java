package com.eight.controller.manage.product;

import com.eight.bean.Page;
import com.eight.bean.ProductInfo;
import com.eight.service.manage.product.IMProductInfoService;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/eight/manage/productInfo")
public class MProductInfoContoller {

    @Autowired
    private IMProductInfoService mProductInfoService;

    @RequestMapping("/productInfoManage")
    public String ProductInfoManage(){
        return "/manage/product/productInfoManage";
    }

    @RequestMapping("/productInfoPage")
    public String ProductInfoPage(Model model){
        model.addAttribute("productCategoryList", mProductInfoService.queryProductCategoryList());
        return "/manage/product/productInfoPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryProductInfoPage")
    @ResponseBody
    public HashMap<String,Object> queryProductInfoPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<ProductInfo> ProductInfoPage = mProductInfoService.queryProductInfoPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(ProductInfoPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryProductInfoList")
    @ResponseBody
    public HashMap<String,Object> queryProductInfoList(){
        return ResultMapUtils.listResult(mProductInfoService.queryProductInfoList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addProductInfo")
    @ResponseBody
    public HashMap<String,Object> addProductInfo(ProductInfo productInfo){
        int i = mProductInfoService.addProductInfo(productInfo);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deleteProductInfo")
    @ResponseBody
    public HashMap<String,Object> deleteProductInfo(ProductInfo productId){
        int i = mProductInfoService.deleteProductInfo(productId);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/modifyProductInfo")
    @ResponseBody
    public HashMap<String,Object> modifyPassword(ProductInfo productInfo){
        int i = mProductInfoService.modifyProductInfo(productInfo);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryProductInfoById")
    public String queryProductInfoById(Integer productId,Model model){
        ProductInfo productInfo = mProductInfoService.queryProductInfoById(productId);
        model.addAttribute("obj", productInfo);
        model.addAttribute("productCategoryList", mProductInfoService.queryProductCategoryList());
        return "manage/product/productInfoPage";
    }
}
