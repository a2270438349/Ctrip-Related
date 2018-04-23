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

  public Course selectCourse(long courseId){
    return this.courseDao.selectCourse(courseId);
  }

}
