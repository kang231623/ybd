package com.buba.ybd.dao;

import com.buba.ybd.pojo.OrderPageInfo;
import com.buba.ybd.pojo.YbdIntegral;
import com.buba.ybd.pojo.YbdUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IntegralMapper {
    List<YbdUser> findManager(@Param("info")OrderPageInfo pageInfo);

    List<YbdIntegral> findExchangeRecords(@Param("info")OrderPageInfo pageInfo);
}
