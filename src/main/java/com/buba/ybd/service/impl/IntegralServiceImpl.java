package com.buba.ybd.service.impl;

import com.buba.ybd.dao.IntegralMapper;
import com.buba.ybd.pojo.OrderPageInfo;
import com.buba.ybd.pojo.YbdIntegral;
import com.buba.ybd.pojo.YbdUser;
import com.buba.ybd.service.IntegralService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegralServiceImpl implements IntegralService {

    @Autowired
    private IntegralMapper integralMapper;


    @Override
    public PageInfo<YbdUser> findManager(OrderPageInfo pageInfo) {
        PageHelper.offsetPage(pageInfo.getOffset(),pageInfo.getLimit());

        List<YbdUser> list = integralMapper.findManager(pageInfo);

        PageInfo info = new PageInfo(list);

        return info;
    }

    @Override
    public PageInfo<YbdIntegral> findExchangeRecords(OrderPageInfo pageInfo,Integer id) {
        pageInfo.setUserId(id);
        PageHelper.offsetPage(pageInfo.getOffset(),pageInfo.getLimit());

        List<YbdIntegral> list = integralMapper.findExchangeRecords(pageInfo);

        PageInfo info = new PageInfo(list);

        return info;
    }
}
