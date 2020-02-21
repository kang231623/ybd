package com.buba.ybd.dao;

import com.buba.ybd.pojo.UserRoleFormdata;
import com.buba.ybd.pojo.YbdRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface YbdRoleMapper {

    List<YbdRole> findRole();

    int addRole(@Param("voio") UserRoleFormdata voio);
}