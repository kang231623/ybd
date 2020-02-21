package com.buba.ybd.dao;

import com.buba.ybd.pojo.UserRoleFormdata;
import com.buba.ybd.pojo.YbdRes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface YbdResMapper {

//    List<YbdRes> loading_res(Integer roleId);

    List<YbdRes> findRes();

    int addRoleRes(@Param("voio") UserRoleFormdata voio);
}