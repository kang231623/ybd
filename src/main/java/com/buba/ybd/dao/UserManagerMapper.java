package com.buba.ybd.dao;

import com.buba.ybd.pojo.OrderPageInfo;
import com.buba.ybd.pojo.UserRoleFormdata;
import com.buba.ybd.pojo.YbdRole;
import com.buba.ybd.pojo.YbdUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserManagerMapper {
    boolean updateUserInfo(YbdUser user);

    boolean updateUserPassword(@Param("id") Integer id, @Param("password") String password);

    List<YbdUser> findManager(@Param("info") OrderPageInfo pageInfo);

    YbdUser findUserByName(String userName);

    int addUser(@Param("voio")UserRoleFormdata voio);

    int addUserRole(@Param("voio")UserRoleFormdata voio);

    int deleteUserRole(Integer userId);

    int deleteUser(Integer userId);
}
