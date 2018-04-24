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
  public void selectCourse(HttpServletRequest request, HttpServletResponse response) throws
      IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    int courseId = Integer.parseInt(request.getParameter("id"));
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

  @RequestMapping("/addCourse.do")
  public void addCourse(HttpServletRequest request, HttpServletResponse response) throws
      IOException {
    response.getWriter().write("开始执行函数");
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    int courseId = Integer.parseInt(request.getParameter("id"));
    String courseName =request.getParameter("name");
    int courseCredit=Integer.parseInt(request.getParameter("credit"));
    Course course=new Course();
    course.setId(courseId);
    course.setName(courseName);
    course.setCredit(courseCredit);
    response.getWriter().write("<h1>开始创建类</h1>");
    int result = this.courseService.addCourse(course);

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

  @RequestMapping("/deleteCourse.do")
  public void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws
      IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    int courseId = Integer.parseInt(request.getParameter("id"));
    boolean result = this.courseService.deleteCourse(courseId);

    // ObjectMapper mapper = new ObjectMapper();
    // response.getWriter().write(mapper.writeValueAsString(user));
    if(result==false){
      response.getWriter().write("<p>删除失败</p>");
    }
    else {
      response.getWriter().write("<p>删除成功</p>");
    }
    response.getWriter().close();
  }

  @RequestMapping("/updateCourse.do")
  public void updateCourse(HttpServletRequest request, HttpServletResponse response) throws
      IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    int courseId = Integer.parseInt(request.getParameter("id"));
    String courseName =request.getParameter("name");
    int courseCredit=Integer.parseInt(request.getParameter("credit"));
    Course course=new Course();
    course.setId(courseId);
    course.setName(courseName);
    course.setCredit(courseCredit);
    int result = this.courseService.updateCourse(course);

    // ObjectMapper mapper = new ObjectMapper();
    // response.getWriter().write(mapper.writeValueAsString(user));
    if(result==-1||result==0){
      response.getWriter().write("<p>修改失败</p>");
    }
    else {
      response.getWriter().write("<p>修改成功</p>");
    }
    response.getWriter().close();
  }

}
