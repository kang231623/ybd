package com.buba.ybd.service.impl;

import com.buba.ybd.dao.YbdGoodnewsMapper;
import com.buba.ybd.dao.YbdUserMapper;
import com.buba.ybd.service.YbdGoodnewsService;
import com.buba.ybd.service.YbdUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YbdGoodnewsServiceImpl implements YbdGoodnewsService {
    @Autowired
    private YbdGoodnewsMapper ybdGoodnewsMapper;

}
