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

    @Override
    public void insertGrade(StudentGrade studentGrade) {
        String sql = "insert into t_grade " +
                "(COURSE_NO, " +
                "STUDENT_USER_ID, " +
                "GRADE_VALUE, " +
                "GRADE_COMMENT) " +
                "values (?,?,?,?)";
        update(sql, studentGrade.getCourseNo(), studentGrade.getStudentUserId(), studentGrade.getGradeValue(),
                studentGrade.getGradeComment());
    }

    @Override
    public void deleteGrade(StudentGrade studentGrade) {
        String sql = "delete from t_grade where COURSE_NO=? and STUDENT_USER_ID=? ";

        update(sql, studentGrade.getCourseNo(), studentGrade.getStudentUserId());
    }

    @Override
    public void updateGrade(StudentGrade studentGrade) {
        String sql = "update t_grade set grade_value = ? , grade_comment = ? where COURSE_NO=? and STUDENT_USER_ID=? ";

        update(sql, studentGrade.getGradeValue(), studentGrade.getGradeComment(), studentGrade.getCourseNo(),
                studentGrade.getStudentUserId());
    }

}
