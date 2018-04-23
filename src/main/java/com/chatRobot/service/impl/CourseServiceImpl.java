package com.chatRobot.service.impl;

import com.chatRobot.dao.ICourseDao;
import com.chatRobot.model.Course;
import com.chatRobot.service.ICourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created In Ctrip. <br/>
 *
 * @author: liangyf <br/>
 * @date: 2018/4/23 <br/>
 */
@Service("courseService")
public class CourseServiceImpl implements ICourseService {

  @Resource
  private ICourseDao courseDao;

  public Course selectCourse(int courseId) {
    return this.courseDao.selectCourse(courseId);
  }

  public boolean addCourse(Course course) {
    return this.courseDao.addCourse(course);
  }

  public boolean deleteCourse(int id) {
    return this.courseDao.deleteCourse(id);
  }

  public boolean updateCourse(Course course) {
    return this.courseDao.updateCourse(course);
  }

}
