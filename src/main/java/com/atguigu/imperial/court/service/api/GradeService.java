package com.atguigu.imperial.court.service.api;

import com.atguigu.imperial.court.entity.StudentGrade;
import com.atguigu.imperial.court.entity.TeacherGrade;

import java.util.List;

public interface GradeService {

    List<StudentGrade> getGradeForOneStudent(String userId);

    List<TeacherGrade> getGradeForOneTeacher(String userId);

    void insertGrade(StudentGrade studentGrade);

    void deleteGrade(StudentGrade studentGrade);

    void updateGrade(StudentGrade studentGrade);
}
