package com.chatRobot.controller;

import javax.servlet.http.HttpServletRequest;

import com.chatRobot.model.User;
import com.chatRobot.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

  @Resource
  private IUserService userService;

  @RequestMapping("/showUser.do")
  public void selectUser(HttpServletRequest request, HttpServletResponse response) throws
      IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    long userId = Long.parseLong(request.getParameter("id"));
    User user = this.userService.selectUser(userId);
    // ObjectMapper mapper = new ObjectMapper();
    // response.getWriter().write(mapper.writeValueAsString(user));
    if(user==null){
      response.getWriter().write("<p>查无结果</p>");
    }
    else {
      response.getWriter().write(
          "<div align='center'>"
              + "<h1 align='center'>返回数据库查询结果</h1>"
              + "</br><p>用户id：" + user.getId() + "</p>"
              + "</br><p>用户名：" + user.getUsername() + "</p>"
              + "</br><p>邮箱：" + user.getEmail() + "</p>"
              + "</div>"

      );
    }
    response.getWriter().close();
  }

}