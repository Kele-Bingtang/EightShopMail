package com.eight.controller.manage.product;

import com.eight.bean.Page;
import com.eight.bean.HourseAppDetail;
import com.eight.service.manage.product.IMHourseAppDetailService;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/eight/manage/hourseAppDetail")
public class MHourseAppDetaillContoller {

    @Autowired
    private IMHourseAppDetailService mHourseAppDetailService;

    @RequestMapping("/hourseAppDetailManage")
    public String HourseAppDetailManage(){
        return "manage/product/hourseAppDetailManage";
    }

    @RequestMapping("/hourseAppDetailPage")
    public String HourseAppDetailPage(Integer categoryId,Model model){
        model.addAttribute("products", mHourseAppDetailService.queryProductInfoByCategory(categoryId));
        return "manage/product/hourseAppDetailPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryHourseAppDetailPage")
    @ResponseBody
    public HashMap<String,Object> queryHourseAppDetailPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<HourseAppDetail> HourseAppDetailPage = mHourseAppDetailService.queryHourseAppDetailPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(HourseAppDetailPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryHourseAppDetailList")
    @ResponseBody
    public HashMap<String,Object> queryHourseAppDetailList(){
        return ResultMapUtils.listResult(mHourseAppDetailService.queryHourseAppDetailList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addHourseAppDetail")
    @ResponseBody
    public HashMap<String,Object> addHourseAppDetail(HourseAppDetail hourseAppDetail){
        int i = mHourseAppDetailService.addHourseAppDetail(hourseAppDetail);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deleteHourseAppDetail")
    @ResponseBody
    public HashMap<String,Object> deleteHourseAppDetail(HourseAppDetail hourseAppDetail){
        int i = mHourseAppDetailService.deleteHourseAppDetail(hourseAppDetail);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/modifyHourseAppDetail")
    @ResponseBody
    public HashMap<String,Object> modifyPassword(HourseAppDetail hourseAppDetail){
        int i = mHourseAppDetailService.modifyHourseAppDetail(hourseAppDetail);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryHourseAppDetailById")
    public String queryHourseAppDetailById(Integer hDetailId,Integer categoryId,Model model){
        HourseAppDetail hourseAppDetail = mHourseAppDetailService.queryHourseAppDetailById(hDetailId);
        model.addAttribute("obj", hourseAppDetail);
        model.addAttribute("products", mHourseAppDetailService.queryProductInfoByCategory(categoryId));
        return "manage/product/hourseAppDetailPage";
    }
}
