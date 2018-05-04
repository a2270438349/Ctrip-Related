package com.chatRobot.controller;

import com.chatRobot.model.CityRequestType;
import com.chatRobot.model.CityResponseType;
import com.chatRobot.service.ICityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created In Ctrip. <br/>
 *
 * @author: liangyf <br/>
 * @date: 2018/5/4 <br/>
 */
@Controller
@RequestMapping("/cityInfo")
public class CityController {

  @Resource
  private ICityService cityService;

  @RequestMapping("/getCityList")
  public void selectCourse(HttpServletRequest request, HttpServletResponse response) throws
      IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    //String provinceName=request.getParameter("provinceName");
    // 解决中文乱码问题
    String provinceName=new String(request.getParameter("provinceName").getBytes("iso-8859-1"),
        "utf-8");
    List<CityResponseType> cityList = this.cityService.selectCity(provinceName);
    if(cityList==null || cityList.size()==0){
      response.getWriter().write("<p>查无结果</p>");
    }
    else {
      response.getWriter().write("<div align='center'><h1 align='center'>数据库查询结果</h1>");
      response.getWriter().write("<table><tr><td>所属省份</td><td>城市ID</td><td>城市名称</td></tr>");
      for(CityResponseType c :cityList){
        response.getWriter().write("<tr><td>" + c.getProvinceName() + "</td>"
            +"<td>" + c.getCityId() + "</td>"
            +"<td>" + c.getCityName() + "</td></tr>");
      }
      response.getWriter().write("</table></div>");
    }
    response.getWriter().close();
  }

  @RequestMapping("/insertCity")
  public void insertCity(HttpServletRequest request, HttpServletResponse response) throws
      IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    int cityId = Integer.parseInt(request.getParameter("cityId"));
    // 解决中文乱码问题
    String provinceName =new String(request.getParameter("provinceName").getBytes("iso-8859-1"),
        "utf-8");
    String cityName=new String(request.getParameter("cityName").getBytes("iso-8859-1"),
        "utf-8");
    CityRequestType city=new CityRequestType();
    city.setCityId(cityId);
    city.setProvinceName(provinceName);
    city.setCityName(cityName);
    int result = this.cityService.insertCity(city);

    // ObjectMapper mapper = new ObjectMapper();
    // response.getWriter().write(mapper.writeValueAsString(user));
    if(result==-1||result==0){
      response.getWriter().write("<p>添加失败</p>");
    }
    else {
      response.getWriter().write("<p>添加成功</p>");
    }
    response.getWriter().close();
  }


  @RequestMapping("/deleteCity")
  public void deleteCity(HttpServletRequest request, HttpServletResponse response) throws
      IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String provinceName=new String(request.getParameter("provinceName").getBytes("iso-8859-1"),
        "utf-8");
    String cityName=new String(request.getParameter("cityName").getBytes("iso-8859-1"),
        "utf-8");
    // 查询是否存在该省份，且该省份下是否存在该城市
    List<CityResponseType> cityList = this.cityService.selectCity(provinceName);
    if(!(cityList==null || cityList.size()==0)){
      CityRequestType city=new CityRequestType();
      city.setProvinceName(provinceName);
      city.setCityName(cityName);
      int result =this.cityService.deleteCity(city);
      if(result==0||result==-1){
        response.getWriter().write("<p>删除失败</p>");
      }
      else {
        response.getWriter().write("<p>删除成功</p>");
      }

    }
    else {
      response.getWriter().write("<p>该省份不存在，或者该省份下不存在该城市");
    }
    response.getWriter().close();
  }

  @RequestMapping("/updateCity")
  public void updateCity(HttpServletRequest request, HttpServletResponse response) throws
      IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String provinceName = new String(request.getParameter("provinceName").getBytes("iso-8859-1"),
        "utf-8");

    String cityName = new String(request.getParameter("cityName").getBytes("iso-8859-1"),
        "utf-8");
    String newCityName = new String(request.getParameter("newCityName").getBytes("iso-8859-1"),
        "utf-8");

    // 查询是否存在该省份，且该省份下是否存在该城市
    List<CityResponseType> cityList = this.cityService.selectCity(provinceName);
    if (!(cityList == null || cityList.size() == 0)) {
      CityRequestType city = new CityRequestType();
      city.setProvinceName(provinceName);
      city.setCityName(cityName);
      city.setNewName(newCityName);
      int result = this.cityService.updateCity(city);
      if (result == 0 || result == -1) {
        response.getWriter().write("<p>更新失败</p>");
      } else {
        response.getWriter().write("<p>更新成功</p>");
      }

    } else {
      response.getWriter().write("<p>该省份不存在，或者该省份下不存在该城市");
    }
    response.getWriter().close();
  }


}
