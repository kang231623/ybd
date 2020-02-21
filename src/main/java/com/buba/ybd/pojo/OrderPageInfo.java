package com.buba.ybd.pojo;

import java.io.Serializable;


public class OrderPageInfo implements Serializable {
    //当前页面数据条数
    private Integer limit;
    //页面数据的的行数
    private Integer offset;
    //排序的字段
    private String sort;
    //排序的规则  desc和asc
    private String order;

    private String houseTitle;

    private String houseresourceNumber;

    private Integer userId;

    private Integer disabled;

    private String startTime;

    private String endTime;
    //角色分页
    private String userName;

    private String roleId;

    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHouseTitle() {
        return houseTitle;
    }

    public void setHouseTitle(String houseTitle) {
        this.houseTitle = houseTitle;
    }

    public String getHouseresourceNumber() {
        return houseresourceNumber;
    }

    public void setHouseresourceNumber(String houseresourceNumber) {
        this.houseresourceNumber = houseresourceNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "LogsPageInfo{" +
                "limit=" + limit +
                ", offset=" + offset +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}

