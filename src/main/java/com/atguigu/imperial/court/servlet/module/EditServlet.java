package com.atguigu.imperial.court.servlet.module;

import com.atguigu.imperial.court.entity.StudentGrade;
import com.atguigu.imperial.court.entity.TUser;
import com.atguigu.imperial.court.entity.TeacherGrade;
import com.atguigu.imperial.court.service.api.GradeService;
import com.atguigu.imperial.court.service.impl.GradeServiceImpl;
import com.atguigu.imperial.court.servlet.base.ModelBaseServlet;
import com.atguigu.imperial.court.util.SipmsCourtConst;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditServlet extends ModelBaseServlet {

    private GradeService gradeService = new GradeServiceImpl();

    protected void editGrade(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        TUser currentUser = (TUser) session.getAttribute(SipmsCourtConst.LOGIN_USER_ATTR_NAME);

        String courseNo = request.getParameter("courseNo");
        String courseTitle = request.getParameter("courseTitle");
        String studentId = request.getParameter("studentId");
        String studentName = request.getParameter("studentName");
        String gradeValue = request.getParameter("gradeValue");
        String comment = request.getParameter("comment");
        String existGrade = request.getParameter("existGrade");

        TeacherGrade studentGradeItem = new TeacherGrade();
        studentGradeItem.setCourseNo(courseNo);
        studentGradeItem.setCourseTitle(courseTitle);
        studentGradeItem.setStudentId(studentId);
        studentGradeItem.setStudentName(studentName);
        studentGradeItem.setGradeValue(gradeValue);
        studentGradeItem.setComment(comment);
        studentGradeItem.setExistGrade(existGrade);

        request.setAttribute("studentGradeItem", studentGradeItem);

        String templateName = "gradeEdit";
        processTemplate(templateName, request, response);
    }

    protected void saveEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        TUser currentUser = (TUser) session.getAttribute(SipmsCourtConst.LOGIN_USER_ATTR_NAME);

        String courseNo = request.getParameter("courseNo");
        String courseTitle = request.getParameter("courseTitle");
        String studentId = request.getParameter("studentId");
        String studentName = request.getParameter("studentName");
        String gradeValue = request.getParameter("gradeValue");
        String comment = request.getParameter("comment");
        String existGrade = request.getParameter("existGrade");

        System.out.println("===courseNo===" + courseNo);
        System.out.println("===courseTitle===" + courseTitle);
        System.out.println("===studentId===" + studentId);
        System.out.println("===studentName===" + studentName);
        System.out.println("===gradeValue===" + gradeValue);
        System.out.println("===comment===" + comment);
        System.out.println("===existGrade===" + existGrade);

        StudentGrade studentGradeItem = new StudentGrade();
        studentGradeItem.setCourseNo(courseNo);
        studentGradeItem.setCourseTitle(courseTitle);
        studentGradeItem.setStudentUserId(studentId);
        studentGradeItem.setGradeValue(gradeValue);
        studentGradeItem.setGradeComment(comment);

        if ("yes".equals(existGrade)) {
            if ((gradeValue != null && !gradeValue.equals("")) || (comment != null && !comment.equals(""))) {
                gradeService.updateGrade(studentGradeItem);
            } else {
                gradeService.deleteGrade(studentGradeItem);
            }
        } else {
            if ((gradeValue != null && !gradeValue.equals("")) || (comment != null && !comment.equals(""))) {
                gradeService.insertGrade(studentGradeItem);
            }
        }

        response.sendRedirect(request.getContextPath() + "/grade?method=showGradeForOneTeacher");
    }
}
