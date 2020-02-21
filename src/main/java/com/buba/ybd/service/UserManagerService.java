package com.buba.ybd.service;

import com.buba.ybd.pojo.*;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserManagerService {
    boolean updateUserInfo(YbdUser user);

    boolean updateUserPassword(Integer id, String password);

    PageInfo<YbdUser> findManager(OrderPageInfo pageInfo);

    List<YbdRes> findRes();

    List<YbdRole> findRole();

    int findUserName(String userName);

    int addUserAndUserRoleAndRes(UserRoleFormdata voio);

    int deleteUser(Integer userId);
}
