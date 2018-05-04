package com.chatRobot.service;

import com.chatRobot.model.CityRequestType;
import com.chatRobot.model.CityResponseType;

import java.util.List;

/**
 * Created In Ctrip. <br/>
 *
 * @author: liangyf <br/>
 * @date: 2018/5/4 <br/>
 */
public interface ICityService {

  List<CityResponseType> selectCity(String provinceName);

  int insertCity(CityRequestType city);

  int deleteCity(CityRequestType city);

  int updateCity(CityRequestType city);

}