package com.atguigu.imperial.court.entity.dao.api;

import com.atguigu.imperial.court.entity.StudentGrade;

import java.util.List;

public interface GradeDao {
    public List<StudentGrade> selectGradeForOneStudent(String userId);
}
