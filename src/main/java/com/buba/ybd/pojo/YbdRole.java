package com.buba.ybd.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class YbdRole implements Serializable {
    private Integer id;

    private String info;

    private String rolecode;

    private String rolename;

    private String type;

    private Boolean disabled;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", info=").append(info);
        sb.append(", rolecode=").append(rolecode);
        sb.append(", rolename=").append(rolename);
        sb.append(", type=").append(type);
        sb.append(", disabled=").append(disabled);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}