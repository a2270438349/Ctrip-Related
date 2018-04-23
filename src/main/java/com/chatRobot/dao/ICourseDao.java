package com.chatRobot.dao;

import com.chatRobot.model.Course;

/**
 * Created In Ctrip. <br/>
 *
 * @author: liangyf <br/>
 * @date: 2018/4/23 <br/>
 */
public interface ICourseDao {
  Course selectCourse(int id);

  boolean addCourse(Course course);

  boolean deleteCourse(int id);

  boolean updateCourse(Course course);
}
