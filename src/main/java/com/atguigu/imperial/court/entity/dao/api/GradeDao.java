package com.atguigu.imperial.court.entity.dao.api;

import com.atguigu.imperial.court.entity.StudentGrade;

import java.util.List;

public interface GradeDao {
    public List<StudentGrade> selectGradeForOneStudent(String userId);

    void insertGrade(StudentGrade studentGrade);

    void deleteGrade(StudentGrade studentGrade);

    void updateGrade(StudentGrade studentGrade);
}
