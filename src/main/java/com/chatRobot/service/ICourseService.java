package com.chatRobot.service;

import com.chatRobot.model.Course;

/**
 * Created In Ctrip. <br/>
 *
 * @author: liangyf <br/>
 * @date: 2018/4/23 <br/>
 */
public interface ICourseService {

  Course selectCourse(long courseId);

}
