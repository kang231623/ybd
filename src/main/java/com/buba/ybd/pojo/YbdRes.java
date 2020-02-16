package com.buba.ybd.pojo;


import java.util.Date;
import java.util.List;

public class YbdRes {

  private Integer id;
  private String icon;
  private String info;
  private String resName;
  private String type;
  private Integer parentId;
  private String disabled;
  private Date createtime;
  private List<YbdRes> resList;

  public YbdRes() {
  }

  public YbdRes(Integer id, String icon, String info, String resName, String type, Integer parentId, String disabled, Date createtime, List<YbdRes> resList) {
    this.id = id;
    this.icon = icon;
    this.info = info;
    this.resName = resName;
    this.type = type;
    this.parentId = parentId;
    this.disabled = disabled;
    this.createtime = createtime;
    this.resList = resList;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public String getResName() {
    return resName;
  }

  public void setResName(String resName) {
    this.resName = resName;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getParentId() {
    return parentId;
  }

  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }

  public String getDisabled() {
    return disabled;
  }

  public void setDisabled(String disabled) {
    this.disabled = disabled;
  }

  public Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }

  public List<YbdRes> getResList() {
    return resList;
  }

  public void setResList(List<YbdRes> resList) {
    this.resList = resList;
  }

  @Override
  public String toString() {
    return "YbdRes{" +
            "id=" + id +
            ", icon='" + icon + '\'' +
            ", info='" + info + '\'' +
            ", resName='" + resName + '\'' +
            ", type='" + type + '\'' +
            ", parentId=" + parentId +
            ", disabled='" + disabled + '\'' +
            ", createtime=" + createtime +
            ", resList=" + resList +
            '}';
  }
}
