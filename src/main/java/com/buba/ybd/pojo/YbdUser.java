package com.buba.ybd.pojo;


public class YbdUser {

  private Integer id;
  private String userName;
  private String password;
  private Integer sex;
  private String phone;
  private String email;
  private Integer integral;
  private Integer quantizationIntegral;
  private String position;
  private String rolename;

  private Integer roleId;

  private Integer chapterSerialNumber;

  public Integer getChapterSerialNumber() {
    return chapterSerialNumber;
  }

  public void setChapterSerialNumber(Integer chapterSerialNumber) {
    this.chapterSerialNumber = chapterSerialNumber;
  }

  public YbdUser() {
  }

  public YbdUser(Integer id, String userName, String password, Integer sex, String phone, String email, Integer integral, Integer quantizationIntegral, String position, String rolename, Integer roleId) {
    this.id = id;
    this.userName = userName;
    this.password = password;
    this.sex = sex;
    this.phone = phone;
    this.email = email;
    this.integral = integral;
    this.quantizationIntegral = quantizationIntegral;
    this.position = position;
    this.rolename = rolename;
    this.roleId = roleId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getIntegral() {
    return integral;
  }

  public void setIntegral(Integer integral) {
    this.integral = integral;
  }

  public Integer getquantizationIntegral() {
    return quantizationIntegral;
  }

  public void setquantizationIntegral(Integer quantizationIntegral) {
    this.quantizationIntegral = quantizationIntegral;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getRolename() {
    return rolename;
  }

  public void setRolename(String rolename) {
    this.rolename = rolename;
  }

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  @Override
  public String toString() {
    return "YbdUser{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", password='" + password + '\'' +
            ", sex=" + sex +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            ", integral=" + integral +
            ", quantizationIntegral=" + quantizationIntegral +
            ", position='" + position + '\'' +
            ", rolename='" + rolename + '\'' +
            ", roleId=" + roleId +
            '}';
  }
}
