package com.chatRobot.dao;

import com.chatRobot.model.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created In Ctrip. <br/>
 *
 * @author: liangyf <br/>
 * @date: 2018/4/23 <br/>
 */
// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class ICourseDaoTest {
  @Autowired
  private ICourseDao dao;
  @Test
  public void selectCourse() throws Exception {
    long id = 1;
    Course course = dao.selectCourse(id);
    System.out.println(course.getCredit());
  }

}