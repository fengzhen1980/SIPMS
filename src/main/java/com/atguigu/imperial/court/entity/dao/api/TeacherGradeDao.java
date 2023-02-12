package com.atguigu.imperial.court.entity.dao.api;

import com.atguigu.imperial.court.entity.TeacherGrade;

import java.util.List;

public interface TeacherGradeDao {

    List<TeacherGrade> selectGradeForOneTeacher(String userId);
}
