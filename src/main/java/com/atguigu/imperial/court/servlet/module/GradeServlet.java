package com.atguigu.imperial.court.servlet.module;

import com.atguigu.imperial.court.entity.StudentGrade;
import com.atguigu.imperial.court.entity.TCourse;
import com.atguigu.imperial.court.entity.TUser;
import com.atguigu.imperial.court.entity.TeacherGrade;
import com.atguigu.imperial.court.service.api.CourseService;
import com.atguigu.imperial.court.service.api.GradeService;
import com.atguigu.imperial.court.service.impl.CourseServiceImpl;
import com.atguigu.imperial.court.service.impl.GradeServiceImpl;
import com.atguigu.imperial.court.servlet.base.ModelBaseServlet;
import com.atguigu.imperial.court.util.SipmsCourtConst;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GradeServlet extends ModelBaseServlet {

    private GradeService gradeService = new GradeServiceImpl();

    private CourseService courseService = new CourseServiceImpl();

    protected void showGradeForOneStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        TUser currentUser = (TUser) session.getAttribute(SipmsCourtConst.LOGIN_USER_ATTR_NAME);

        List<StudentGrade> gradeList = gradeService.getGradeForOneStudent(currentUser.getUserId());

        request.setAttribute("gradeList", gradeList);

        String template = "studentGrade-list";
        processTemplate(template, request, response);

    }

    protected void showGradeForOneTeacher(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        TUser currentUser = (TUser) session.getAttribute(SipmsCourtConst.LOGIN_USER_ATTR_NAME);

        String userId = currentUser.getUserId();

        TCourse course = courseService.getCourseByTeacherId(userId);

        String courseNo = course.getCourseNo();
        String courseTitle = course.getCourseTitle();

        List<TeacherGrade> studentGradeList = gradeService.getGradeForOneTeacher(userId);

        for (TeacherGrade item : studentGradeList) {
            item.setCourseNo(courseNo);
            item.setCourseTitle(courseTitle);
        }

        request.setAttribute("studentGradeList", studentGradeList);

        String template = "teacherGrade-list";
        processTemplate(template, request, response);
    }
}
