package com.atguigu.imperial.court.entity.dao.impl;

import com.atguigu.imperial.court.entity.StudentGrade;
import com.atguigu.imperial.court.entity.dao.BaseDao;
import com.atguigu.imperial.court.entity.dao.api.GradeDao;

import java.util.List;

public class GradeDaoImpl extends BaseDao<StudentGrade> implements GradeDao {
    @Override
    public List<StudentGrade> selectGradeForOneStudent(String userId) {

        String sql = "select\n" +
                " g.COURSE_NO courseNo,\n" +
                " c.COURSE_TITLE courseTitle,\n" +
                " g.STUDENT_USER_ID studentUserId,\n" +
                " g.GRADE_VALUE gradeValue,\n" +
                " g.GRADE_COMMENT gradeComment\n" +
                " FROM\n" +
                " t_grade g \n" +
                " left join \n" +
                " t_course c \n" +
                " on c.COURSE_NO = g.COURSE_NO \n" +
                " where g.STUDENT_USER_ID =? ";

        return getBeanList(sql, StudentGrade.class, userId);
    }
}
