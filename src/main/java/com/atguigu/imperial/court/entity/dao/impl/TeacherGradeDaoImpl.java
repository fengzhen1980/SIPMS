package com.atguigu.imperial.court.entity.dao.impl;

import com.atguigu.imperial.court.entity.TeacherGrade;
import com.atguigu.imperial.court.entity.dao.BaseDao;
import com.atguigu.imperial.court.entity.dao.api.TeacherGradeDao;

import java.util.List;

public class TeacherGradeDaoImpl extends BaseDao<TeacherGrade> implements TeacherGradeDao {

    @Override
    public List<TeacherGrade> selectGradeForOneTeacher(String userId) {

        String sql = "select \n" +
                "t2.course_no courseNo, \n" +
                "t3.COURSE_TITLE courseTitle, \n" +
                "t1.USER_Id studentId, \n" +
                "concat_ws(' ', t1.USER_FIRST_NAME , t1.USER_LAST_NAME) studentName, \n" +
                "t2.grade_value gradeValue , \n" +
                "t2.grade_comment comment, \n" +
                "if(t2.STUDENT_USER_ID is null, 'no', 'yes') existGrade \n" +
                "from  t_user t1 \n" +
                "left join t_grade t2 on t2.STUDENT_USER_ID = t1.USER_Id and t2.course_no = (select course_no from " +
                "t_course where TEACHER_USER_ID = ?) \n" +
                "left join t_course t3 on t3.COURSE_NO = t2.COURSE_NO \n" +
                "where \n" +
                "t1.USER_CATEGORY = 'student' \n" +
                "order by studentId \n";

        return getBeanList(sql, TeacherGrade.class, userId);
    }
}
