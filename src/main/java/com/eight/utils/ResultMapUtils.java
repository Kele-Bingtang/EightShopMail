package com.eight.utils;


import com.eight.bean.ManagerInfo;
import com.eight.bean.ManagerPower;
import com.eight.bean.Page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResultMapUtils {

    /**
     * 登录返回结果
     * @param msg 信息
     * @param code 登录码，1成功，2失败
     * @return 登录结果
     */
    public static HashMap<String,Object> loginResult(String msg,String code,String username){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("msg", msg);
        resultMap.put("code", code);
        if("1".equals(code)){
            resultMap.put("icon", 1);//打勾
        }else {
            resultMap.put("icon", 2);//打叉
        }
        resultMap.put("anim", 4);//从走翻滚
        if(username != null){
            resultMap.put("username", username);
        }
        return resultMap;
    }


    /**
     * 分页查询结果
     */
    public static <T> HashMap<String,Object> pageResult(Page<T> page){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",page.getTotalPageCount());
        resultMap.put("data",page.getItem());
        return resultMap;
    }

    /**
     * 异常数据统一处理
     */
    public static HashMap<String,Object> exceptionResult(Exception e){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",1);
        resultMap.put("msg",e.getMessage());
        return resultMap;
    }

    /**
     * 保存成功的统一返回格式
     */
    public static HashMap<String,Object> saveResult(int i){
        HashMap<String,Object> resultMap = new HashMap<>();
        if(i == 0){
            resultMap.put("msg","保存失败");
            resultMap.put("code",1);
            resultMap.put("icon",5);
            resultMap.put("anim",6);
        }else {
            resultMap.put("msg","保存成功");
            resultMap.put("code",0);
            resultMap.put("icon",1);
            resultMap.put("anim",4);
        }
        return resultMap;
    }

    /**
     * 删除成功的统一返回格式
     */
    public static HashMap<String,Object> deleteResult(int i){
        HashMap<String,Object> resultMap = new HashMap<>();
        if(i == 0){
            resultMap.put("msg","删除失败");
            resultMap.put("code",1);
            resultMap.put("icon",5);
            resultMap.put("anim",6);
        }else {
            resultMap.put("msg","删除成功");
            resultMap.put("code",0);
            resultMap.put("icon",1);
            resultMap.put("anim",4);
        }
        return resultMap;
    }

    /**
     * List返回格式
     */
    public static HashMap<String,Object> listResult(List<?> list){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",0);
        if(list!=null&&list.size()>0){
            resultMap.put("msg","");
        }else {
            resultMap.put("msg","没有查询到数据！");
        }
        resultMap.put("data",list);
        return resultMap;
    }


}
