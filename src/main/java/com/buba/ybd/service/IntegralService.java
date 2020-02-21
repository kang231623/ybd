package com.buba.ybd.service;

import com.buba.ybd.pojo.OrderPageInfo;
import com.buba.ybd.pojo.YbdIntegral;
import com.buba.ybd.pojo.YbdUser;
import com.github.pagehelper.PageInfo;

public interface IntegralService {
    PageInfo<YbdUser> findManager(OrderPageInfo pageInfo);

    PageInfo<YbdIntegral> findExchangeRecords(OrderPageInfo pageInfo,Integer id);
}
