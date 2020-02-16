package com.buba.ybd.service;

import com.buba.ybd.pojo.YbdRes;
import com.buba.ybd.pojo.YbdUser;

import java.util.List;

public interface YbdUserService {

    /**
     * 登录
     * @param username
     * @return
     */
    YbdUser findUserByName(String username);

    /**
     * 加载权限
     * @param roleId
     * @return
     */
    List<YbdRes> loading_res(Integer roleId);
}
