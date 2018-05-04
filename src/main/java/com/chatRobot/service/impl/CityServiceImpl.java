package com.chatRobot.service.impl;

import com.chatRobot.dao.ICityDao;
import com.chatRobot.model.CityRequestType;
import com.chatRobot.model.CityResponseType;
import com.chatRobot.service.ICityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created In Ctrip. <br/>
 *
 * @author: liangyf <br/>
 * @date: 2018/5/4 <br/>
 */
@Service("cityService")
public class CityServiceImpl implements ICityService {

  @Resource
  private ICityDao cityDao;

  public List<CityResponseType> selectCity(String provinceName) {
    return this.cityDao.selectCity(provinceName);
  }

  public int insertCity(CityRequestType city){
    return this.cityDao.insertCity(city);
  }

  public int deleteCity(CityRequestType city){
    return this.cityDao.deleteCity(city);
  }

  public int updateCity(CityRequestType city){
    return this.cityDao.updateCity(city);
  }

}