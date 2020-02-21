package com.buba.ybd.controller;

import com.buba.ybd.pojo.*;
import com.buba.ybd.service.UserManagerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/usermanager")
public class UserManagerController {

    @Autowired
    private UserManagerService userManagerService;

//    修改用户信息
    @RequestMapping("/updateUserInfo")
    @ResponseBody
    private boolean updateUserInfo(YbdUser user){

       boolean b = userManagerService.updateUserInfo(user);

        return b;
    }

//    生成验证码
    @RequestMapping("/getmobileCode")
    @ResponseBody
    public String getmobileCode(HttpSession session) {
        //生成随机4位数验证码
        int code = (int) ((Math.random() * 9 + 1) * 1000);
        //将int 转换成 string
        String pCode = String.valueOf(code);

        session.setAttribute("telCode",pCode);

        return pCode;
    }

//    检验验证码
    @RequestMapping("/verifyMobileCode")
    @ResponseBody
    public Boolean verifyMobileCode(String mobileCode,HttpSession session) {

        String code = (String) session.getAttribute("telCode");
        //进行判断
        if (mobileCode.equals(code)) {
            return true;
        }
        return false;
    }

//    验证完毕，修改密码
    @RequestMapping("/updateUserPassword")
    @ResponseBody
    private boolean updateUserPassword(HttpSession session,String password){
        //从session域中取出数据
        YbdUser ybdUser = (YbdUser)session.getAttribute("USER_SESSION");
        //修改密码
        boolean b = userManagerService.updateUserPassword(ybdUser.getId(),password);
        //返回是否进行过修改
        return b;
    }

//    用户信息
    @RequestMapping("findManager")
    @ResponseBody
    public PageInfo<YbdUser> findManager(OrderPageInfo pageInfo) {
        PageInfo<YbdUser> user = userManagerService.findManager(pageInfo);
        return user;
    }

//    查询所有权限
    @RequestMapping("findRes")
    @ResponseBody
    public List<YbdRes> findRes(){
        List<YbdRes> list = userManagerService.findRes();
        return list;
    }

//    查询所有角色
    @RequestMapping("findRole")
    @ResponseBody
    public List<YbdRole> findRole(){

        List<YbdRole> roles = userManagerService.findRole();

        return roles;
    }

//    验证用户唯一性
    @RequestMapping("findUserName")
    @ResponseBody
    public int findUserName(String userName){

        int i=  userManagerService.findUserName(userName);

        return i;
    }

//    添加用户和用户角色信息
    @RequestMapping("addUserAndUserRoleAndRes")
    @ResponseBody
    public long addUserAndUserRoleAndRes(UserRoleFormdata voio){

        int count = userManagerService.addUserAndUserRoleAndRes(voio);

        if(count>0){
            return count;
        }

        return count;
    }

//    删除用户
    @RequestMapping("deleteUser")
    @ResponseBody
    public int deleteUser(Integer userId){

        int i= userManagerService.deleteUser(userId);

        return i;
    }
}
