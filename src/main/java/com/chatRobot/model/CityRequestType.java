package com.chatRobot.model;

/**
 * Created In Ctrip. <br/>
 *
 * @author: liangyf <br/>
 * @date: 2018/5/4 <br/>
 */
public class CityRequestType {
  private int bussinessType;
  private String provinceName;
  private int cityId;
  private String cityName;
  private String newName;

  public String getNewName() {
    return newName;
  }

  public void setNewName(String newName) {
    this.newName = newName;
  }


  public int getBussinessType() {
    return bussinessType;
  }

  public void setBussinessType(int bussinessType) {
    this.bussinessType = bussinessType;
  }


  public String getProvinceName() {
    return provinceName;
  }

  public void setProvinceName(String provinceName) {
    this.provinceName = provinceName;
  }

  public int getCityId() {
    return cityId;
  }

  public void setCityId(int cityId) {
    this.cityId = cityId;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }
}
