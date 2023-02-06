package com.atguigu.imperial.court.service.api;

import com.atguigu.imperial.court.entity.StudentGrade;

import java.util.List;

public interface GradeService {

    List<StudentGrade> getGradeForOneStudent(String userId);
}
