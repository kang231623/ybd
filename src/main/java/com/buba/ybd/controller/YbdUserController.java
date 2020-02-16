package com.buba.ybd.controller;

import com.buba.ybd.pojo.YbdRes;
import com.buba.ybd.pojo.YbdUser;
import com.buba.ybd.service.impl.YbdUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: bcys
 * @description: 用户登录控制
 * @author: 罗子鉴
 * @create: 2019-03-21 14:39
 **/
@Controller
@RequestMapping("/user")
public class YbdUserController {
    @Autowired
    private YbdUserServiceImpl ybdUserServiceImpl;
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,String> UserLogin(String userName, String password, HttpSession session, HttpServletRequest request){


        Map<String,String> map = new HashMap<String,String>();
        String verCode = (String)session.getAttribute("verCode");

        YbdUser user = ybdUserServiceImpl.findUserByName(userName);
        if(user==null){
            map.put("message","用户不存在，请注册再次登录");
            return map;
        }
        if(!user.getPassword().equals(password)){
            map.put("message","密码不正确请重新输入");
            return map;
        }

        session.setAttribute("USER_SESSION",user);

        map.put("flag","true");

        return map;
    }

    @RequestMapping("/logout")
    public String  logout(HttpSession session){
        //根据键删除session中的值
        session.removeAttribute("USER_SESSION");

        session.invalidate();

        return "redirect:/jsps/login.jsp";

    }
    @RequestMapping("/loading_res")
    @ResponseBody
    public List<YbdRes> loading_res(HttpSession session){
        YbdUser user = (YbdUser)session.getAttribute("USER_SESSION");

        List<YbdRes> list = ybdUserServiceImpl.loading_res(user.getRoleId());

        return list;
    }





}

