package com.buba.ybd.dao;


import com.buba.ybd.pojo.YbdRes;
import com.buba.ybd.pojo.YbdUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YbdUserMapper {
    /**
     * 登录
     * @param userName
     * @return
     */
    YbdUser findUserByName(String userName);


    List<YbdRes> loading_res(Integer roleId);
}