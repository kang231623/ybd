package com.buba.ybd.service.impl;

import com.buba.ybd.dao.UserManagerMapper;
import com.buba.ybd.dao.YbdResMapper;
import com.buba.ybd.dao.YbdRoleMapper;
import com.buba.ybd.pojo.*;
import com.buba.ybd.service.UserManagerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserManagerServiceImpl implements UserManagerService {

    @Autowired
    private UserManagerMapper userManagerMapper;

    @Autowired
    private YbdRoleMapper ybdRoleMapper;

    @Autowired
    private YbdResMapper ybdResMapper;

    @Override
    public boolean updateUserInfo(YbdUser user) {
        return userManagerMapper.updateUserInfo(user);
    }

    @Override
    public boolean updateUserPassword(Integer id, String password) {
        return userManagerMapper.updateUserPassword(id,password);
    }

    @Override
    public PageInfo<YbdUser> findManager(OrderPageInfo pageInfo) {
        PageHelper.offsetPage(pageInfo.getOffset(),pageInfo.getLimit());

        List<YbdUser> list = userManagerMapper.findManager(pageInfo);

        PageInfo info = new PageInfo(list);

        return info;
    }

    @Override
    public List<YbdRes> findRes() {
        List<YbdRes> list = ybdResMapper.findRes();

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

    @Override
    public List<YbdRole> findRole() {
        List<YbdRole> roles = ybdRoleMapper.findRole();

        return roles;
    }

    @Override
    public int findUserName(String userName) {
        YbdUser ybdUser= userManagerMapper.findUserByName(userName);
        if(ybdUser!=null){
            return 1;
        }
        return 0;
    }


//    添加用户角色权限
    @Override
    public int addUserAndUserRoleAndRes(UserRoleFormdata voio) {
        int count=0;
//        添加用户
        count = userManagerMapper.addUser(voio);

        if(voio.getRoleId()==0){
//            添加角色
            count = ybdRoleMapper.addRole(voio);
            if(count>0){
//                添加角色权限
                count= ybdResMapper.addRoleRes(voio);
            }
        }
        if(count>0){
//            添加用户角色
            count = userManagerMapper.addUserRole(voio);
        }
        return count;
    }

    //删除用户
    @Override
    public int deleteUser(Integer userId) {
//        删除角色权限
        int i = userManagerMapper.deleteUserRole(userId);
        int j = 0;
        if(i>0){
//            删除用户
            j = userManagerMapper.deleteUser(userId);
        }
        return j;
    }
}
