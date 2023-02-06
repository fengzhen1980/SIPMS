package com.atguigu.imperial.court.service.impl;

import com.atguigu.imperial.court.entity.StudentGrade;
import com.atguigu.imperial.court.entity.dao.api.GradeDao;
import com.atguigu.imperial.court.entity.dao.impl.GradeDaoImpl;
import com.atguigu.imperial.court.service.api.GradeService;

import java.util.List;

public class GradeServiceImpl implements GradeService {

    private GradeDao gradeDao = new GradeDaoImpl();

    @Override
    public List<StudentGrade> getGradeForOneStudent(String userId) {
        return gradeDao.selectGradeForOneStudent(userId);
    }
}
