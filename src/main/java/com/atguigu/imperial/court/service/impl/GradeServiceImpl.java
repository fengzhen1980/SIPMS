package com.atguigu.imperial.court.service.impl;

import com.atguigu.imperial.court.entity.StudentGrade;
import com.atguigu.imperial.court.entity.TeacherGrade;
import com.atguigu.imperial.court.entity.dao.api.GradeDao;
import com.atguigu.imperial.court.entity.dao.api.TeacherGradeDao;
import com.atguigu.imperial.court.entity.dao.impl.GradeDaoImpl;
import com.atguigu.imperial.court.entity.dao.impl.TeacherGradeDaoImpl;
import com.atguigu.imperial.court.service.api.GradeService;

import java.util.List;

public class GradeServiceImpl implements GradeService {

    private GradeDao gradeDao = new GradeDaoImpl();

    private TeacherGradeDao teacherGradeDao = new TeacherGradeDaoImpl();

    @Override
    public List<StudentGrade> getGradeForOneStudent(String userId) {
        return gradeDao.selectGradeForOneStudent(userId);
    }

    @Override
    public List<TeacherGrade> getGradeForOneTeacher(String userId) {
        return teacherGradeDao.selectGradeForOneTeacher(userId);
    }

    @Override
    public void insertGrade(StudentGrade studentGrade) {
        gradeDao.insertGrade(studentGrade);
    }

    @Override
    public void deleteGrade(StudentGrade studentGrade) {
        gradeDao.deleteGrade(studentGrade);
    }

    @Override
    public void updateGrade(StudentGrade studentGrade) {
        gradeDao.updateGrade(studentGrade);
    }
}
