package com.atguigu.imperial.court.entity.dao.api;

import com.atguigu.imperial.court.entity.TCourse;

public interface CourseDao {
    TCourse selectCourseByTeacherId(String userId);

    void insertCourse(TCourse course);
}
