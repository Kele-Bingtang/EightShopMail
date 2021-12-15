package com.eight.controller.manage.product;

import com.eight.bean.Page;
import com.eight.bean.PhoneDetail;
import com.eight.service.manage.product.IMPhoneDetailService;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/eight/manage/phoneDetail")
public class MPhoneDetailContoller {

    @Autowired
    private IMPhoneDetailService mPhoneDetailService;

    @RequestMapping("/phoneDetailManage")
    public String PhoneDetailManage(){
        return "manage/product/phoneDetailManage";
    }

    @RequestMapping("/phoneDetailPage")
    public String PhoneDetailPage(Integer categoryId,Model model){
        model.addAttribute("products",mPhoneDetailService.queryProductInfoByCategory(categoryId));
        return "manage/product/phoneDetailPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryPhoneDetailPage")
    @ResponseBody
    public HashMap<String,Object> queryPhoneDetailPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<PhoneDetail> PhoneDetailPage = mPhoneDetailService.queryPhoneDetailPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(PhoneDetailPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryPhoneDetailList")
    @ResponseBody
    public HashMap<String,Object> queryPhoneDetailList(){
        return ResultMapUtils.listResult(mPhoneDetailService.queryPhoneDetailList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addPhoneDetail")
    @ResponseBody
    public HashMap<String,Object> addPhoneDetail(PhoneDetail phoneDetail){
        int i = mPhoneDetailService.addPhoneDetail(phoneDetail);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deletePhoneDetail")
    @ResponseBody
    public HashMap<String,Object> deletePhoneDetail(PhoneDetail phoneDetail){
        int i = mPhoneDetailService.deletePhoneDetail(phoneDetail);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/modifyPhoneDetail")
    @ResponseBody
    public HashMap<String,Object> modifyPassword(PhoneDetail phoneDetail){
        int i = mPhoneDetailService.modifyPhoneDetail(phoneDetail);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryPhoneDetailById")
    public String queryPhoneDetailById(Integer pDetailId,Integer categoryId,Model model){
        PhoneDetail phoneDetail = mPhoneDetailService.queryPhoneDetailById(pDetailId);
        model.addAttribute("obj", phoneDetail);
        model.addAttribute("products",mPhoneDetailService.queryProductInfoByCategory(1));
        model.addAttribute("products",mPhoneDetailService.queryProductInfoByCategory(categoryId));

        return "manage/product/phoneDetailPage";
    }
}
