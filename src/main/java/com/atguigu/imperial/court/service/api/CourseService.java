package com.atguigu.imperial.court.service.api;

import com.atguigu.imperial.court.entity.TCourse;

public interface CourseService {

    TCourse getCourseByTeacherId(String userId);

    TCourse getCourseByCourseNo(String CourseNo);

    void insertCourse(TCourse course);
}
