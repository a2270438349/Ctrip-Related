package com.chatRobot.model;

/**
 * Created In Ctrip. <br/>
 *
 * @author: liangyf <br/>
 * @date: 2018/5/4 <br/>
 */
public class City {

  private int cityId;
  private int provinceId;
  private String name;

  public int getProvinceId() {
    return provinceId;
  }

  public void setProvinceId(int provinceId) {
    this.provinceId = provinceId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public int getCityId() {
    return cityId;
  }

  public void setCityId(int cityId) {
    this.cityId = cityId;
  }
}
