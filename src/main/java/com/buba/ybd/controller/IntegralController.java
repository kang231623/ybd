package com.buba.ybd.controller;

import com.buba.ybd.pojo.OrderPageInfo;
import com.buba.ybd.pojo.YbdIntegral;
import com.buba.ybd.pojo.YbdUser;
import com.buba.ybd.service.IntegralService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/integral")
@Controller
public class IntegralController {

    @Autowired
    private IntegralService integralService;

//    查询用户
    @RequestMapping("/findUser")
    @ResponseBody
    public PageInfo<YbdUser> findUser(OrderPageInfo pageInfo){
        PageInfo<YbdUser> user = integralService.findManager(pageInfo);
        return user;
    }

//    用户积分兑换操作
    @RequestMapping("/findExchangeRecords")
    @ResponseBody
    public PageInfo<YbdIntegral> findExchangeRecords(OrderPageInfo pageInfo,Integer id){
        PageInfo<YbdIntegral> ybdIntegral = integralService.findExchangeRecords(pageInfo,id);
        return ybdIntegral;
    }
}
