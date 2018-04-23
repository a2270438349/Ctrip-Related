package com.chatRobot.controller;

import com.chatRobot.model.Course;
import com.chatRobot.model.User;
import com.chatRobot.service.ICourseService;
import com.chatRobot.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created In Ctrip. <br/>
 *
 * @author: liangyf <br/>
 * @date: 2018/4/23 <br/>
 */
@Controller
@RequestMapping("/course")
public class CourseController {

  @Resource
  private ICourseService courseService;

  @RequestMapping("/showCourse.do")
  public void selectUser(HttpServletRequest request, HttpServletResponse response) throws
      IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    long courseId = Long.parseLong(request.getParameter("id"));
    Course course = this.courseService.selectCourse(courseId);
    // ObjectMapper mapper = new ObjectMapper();
    // response.getWriter().write(mapper.writeValueAsString(user));
    if(course==null){
      response.getWriter().write("<p>查无结果</p>");
    }
    else {
      response.getWriter().write(
          "<div align='center'>"
              + "<h1 align='center'>返回数据库查询结果</h1>"
              + "</br><p>课程id：" + course.getId() + "</p>"
              + "</br><p>课程名：" + course.getName() + "</p>"
              + "</br><p>学分：" + course.getCredit() + "</p>"
              + "</div>"

      );
    }
    response.getWriter().close();
  }
}
