package com.buba.ybd.service.impl;

import com.buba.ybd.dao.YbdUserMapper;
import com.buba.ybd.pojo.YbdRes;
import com.buba.ybd.pojo.YbdUser;
import com.buba.ybd.service.YbdUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YbdUserServiceImpl implements YbdUserService {
    @Autowired
    private YbdUserMapper ybdUserMapper;

    @Override
    public YbdUser findUserByName(String username) {
        return ybdUserMapper.findUserByName(username);
    }
    /**
     * 加载权限
     * @param roleId
     * @return
     */
    @Override
    public List<YbdRes> loading_res(Integer roleId) {

        List<YbdRes> list = ybdUserMapper.loading_res(roleId);

        List<YbdRes> resList= new ArrayList<YbdRes>();

        for (YbdRes res:list) {
            if(res.getParentId()==0){
                List<YbdRes> resChildList= new ArrayList<YbdRes>();
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i).getParentId()==res.getId()){
                        resChildList.add(list.get(i));
                    }
                }
                res.setResList(resChildList);
                resList.add(res);
            }
        }

        return resList;
    }
}
