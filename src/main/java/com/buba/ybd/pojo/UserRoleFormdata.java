package com.buba.ybd.pojo;

import java.util.List;

public class UserRoleFormdata {

    private Integer userId;
    private String username;
    private String password;
    private Integer roleId;
    private String rolename;
    private String rolecode;
    private List<String> listRes;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode;
    }

    public List<String> getListRes() {
        return listRes;
    }

    public void setListRes(List<String> listRes) {
        this.listRes = listRes;
    }
}

