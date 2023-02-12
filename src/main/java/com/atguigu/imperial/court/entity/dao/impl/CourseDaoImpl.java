package com.atguigu.imperial.court.entity.dao.impl;

import com.atguigu.imperial.court.entity.TCourse;
import com.atguigu.imperial.court.entity.dao.BaseDao;
import com.atguigu.imperial.court.entity.dao.api.CourseDao;

public class CourseDaoImpl extends BaseDao<TCourse> implements CourseDao {

    @Override
    public TCourse selectCourseByTeacherId(String userId) {

        String sql = "select COURSE_NO courseNo, " +
                "COURSE_TITLE courseTitle, " +
                "COURSE_HOURS courseHours, " +
                "TEACHER_USER_ID teacherUserId, " +
                "COURSE_DESCRIPTION courseDescription " +
                "from t_course where TEACHER_USER_ID=? ";

        return super.getSingleBean(sql, TCourse.class, userId);
    }

    @Override
    public void insertCourse(TCourse course) {
        String sql = "insert into t_course " +
                "(COURSE_NO, " +
                "COURSE_TITLE, " +
                "TEACHER_USER_ID) " +
                "values (?,?,?)";
        update(sql, course.getCourseNo(), course.getCourseTitle(), course.getTeacherUserId());
    }
}
