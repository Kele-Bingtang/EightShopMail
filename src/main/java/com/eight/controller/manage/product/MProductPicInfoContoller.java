package com.eight.controller.manage.product;

import com.eight.bean.Page;
import com.eight.bean.ProductPicInfo;
import com.eight.service.manage.product.IMProductPicInfoService;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/eight/manage/productPicInfo")
public class MProductPicInfoContoller {

    @Autowired
    private IMProductPicInfoService mProductPicInfoService;

    @RequestMapping("/productPicInfoManage")
    public String ProductPicInfoManage(){
        return "/manage/product/productPicInfoManage";
    }

    @RequestMapping("/productPicInfoPage")
    public String ProductPicInfoPage(Model model){
        model.addAttribute("productInfos", mProductPicInfoService.queryProductInfoList());
        return "/manage/product/productPicInfoPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryProductPicInfoPage")
    @ResponseBody
    public HashMap<String,Object> queryProductPicInfoPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<ProductPicInfo> ProductPicInfoPage = mProductPicInfoService.queryProductPicInfoPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(ProductPicInfoPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryProductPicInfoList")
    @ResponseBody
    public HashMap<String,Object> queryProductPicInfoList(){
        return ResultMapUtils.listResult(mProductPicInfoService.queryProductPicInfoList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addProductPicInfo")
    @ResponseBody
    public HashMap<String,Object> addProductPicInfo(ProductPicInfo productPicInfo){
        int i = mProductPicInfoService.addProductPicInfo(productPicInfo);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deleteProductPicInfo")
    @ResponseBody
    public HashMap<String,Object> deleteProductPicInfo(ProductPicInfo productPicInfo){
        int i = mProductPicInfoService.deleteProductPicInfo(productPicInfo);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/modifyProductPicInfo")
    @ResponseBody
    public HashMap<String,Object> modifyPassword(ProductPicInfo productPicInfo){
        int i = mProductPicInfoService.modifyProductPicInfo(productPicInfo);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryProductPicInfoById")
    public String queryProductPicInfoById(Integer productPicId,Model model){
        ProductPicInfo productPicInfo = mProductPicInfoService.queryProductPicInfoById(productPicId);
        model.addAttribute("obj", productPicInfo);
        model.addAttribute("productInfos", mProductPicInfoService.queryProductInfoList());
        return "manage/product/productPicInfoPage";
    }
}
