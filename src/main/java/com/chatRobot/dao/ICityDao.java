package com.chatRobot.dao;

import com.chatRobot.model.CityRequestType;
import com.chatRobot.model.CityResponseType;

import java.util.List;

/**
 * Created In Ctrip. <br/>
 *
 * @author: liangyf <br/>
 * @date: 2018/5/4 <br/>
 */
public interface ICityDao {

  // 查
  List<CityResponseType> selectCity(String provinceName);

  // 增
  int insertCity(CityRequestType city);

  // 删
  int deleteCity(CityRequestType city);

  // 查
  int updateCity(CityRequestType city);

}