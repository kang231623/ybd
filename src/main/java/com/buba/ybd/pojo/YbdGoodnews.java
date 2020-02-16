package com.sample;


import java.util.Date;

public class YbdGoodnews {

  private Integer id;
  private String userName;
  private Integer sex;
  private Integer age;
  private String email;
  private String phone;
  private Date entrytime;
  private String entrycompany;
  private String salary;
  private String treatment;
  private String personalPic;

  public YbdGoodnews() {
  }

  public YbdGoodnews(Integer id, String userName, Integer sex, Integer age, String email, String phone, Date entrytime, String entrycompany, String salary, String treatment, String personalPic) {
    this.id = id;
    this.userName = userName;
    this.sex = sex;
    this.age = age;
    this.email = email;
    this.phone = phone;
    this.entrytime = entrytime;
    this.entrycompany = entrycompany;
    this.salary = salary;
    this.treatment = treatment;
    this.personalPic = personalPic;
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

  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Date getEntrytime() {
    return entrytime;
  }

  public void setEntrytime(Date entrytime) {
    this.entrytime = entrytime;
  }

  public String getEntrycompany() {
    return entrycompany;
  }

  public void setEntrycompany(String entrycompany) {
    this.entrycompany = entrycompany;
  }

  public String getSalary() {
    return salary;
  }

  public void setSalary(String salary) {
    this.salary = salary;
  }

  public String getTreatment() {
    return treatment;
  }

  public void setTreatment(String treatment) {
    this.treatment = treatment;
  }

  public String getPersonalPic() {
    return personalPic;
  }

  public void setPersonalPic(String personalPic) {
    this.personalPic = personalPic;
  }

  @Override
  public String toString() {
    return "YbdGoodnews{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", sex=" + sex +
            ", age=" + age +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", entrytime=" + entrytime +
            ", entrycompany='" + entrycompany + '\'' +
            ", salary='" + salary + '\'' +
            ", treatment='" + treatment + '\'' +
            ", personalPic='" + personalPic + '\'' +
            '}';
  }
}
