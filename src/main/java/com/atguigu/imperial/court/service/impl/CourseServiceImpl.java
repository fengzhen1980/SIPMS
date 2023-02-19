package com.atguigu.imperial.court.service.impl;

import com.atguigu.imperial.court.entity.TCourse;
import com.atguigu.imperial.court.entity.dao.api.CourseDao;
import com.atguigu.imperial.court.entity.dao.impl.CourseDaoImpl;
import com.atguigu.imperial.court.service.api.CourseService;

public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao = new CourseDaoImpl();

    @Override
    public TCourse getCourseByTeacherId(String userId) {
        return courseDao.selectCourseByTeacherId(userId);
    }

    @Override
    public TCourse getCourseByCourseNo(String CourseNo) {
        return courseDao.selectCourseByCourseNo(CourseNo);
    }

    @Override
    public void insertCourse(TCourse course) {
        courseDao.insertCourse(course);
    }
}
