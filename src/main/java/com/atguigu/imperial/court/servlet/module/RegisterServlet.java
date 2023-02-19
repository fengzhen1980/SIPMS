package com.atguigu.imperial.court.servlet.module;

import com.atguigu.imperial.court.entity.TCourse;
import com.atguigu.imperial.court.entity.TUser;
import com.atguigu.imperial.court.service.api.CourseService;
import com.atguigu.imperial.court.service.api.RegisterService;
import com.atguigu.imperial.court.service.impl.CourseServiceImpl;
import com.atguigu.imperial.court.service.impl.RegisterServiceImpl;
import com.atguigu.imperial.court.servlet.base.ModelBaseServlet;
import com.atguigu.imperial.court.util.SipmsCourtConst;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends ModelBaseServlet {

    // creat service
    private RegisterService registerService = new RegisterServiceImpl();

    private CourseService courseService = new CourseServiceImpl();

    protected void initRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 5.前往指定的页面视图
        // 前往临时页面
        //String templateName = "temp";
        //processTemplate(templateName, request, response);

        // 前往用户注册页面
        String templateName = "register";
        processTemplate(templateName, request, response);
    }

    protected void doRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean inputErrFlag = false;

        String templateName = new String();
        // 获取请求参数
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String passwordAgain = request.getParameter("passwordAgain");
        String userCategory = request.getParameter("userCategory");
        String userFirstName = request.getParameter("userFirstName");
        String userLastName = request.getParameter("userLastName");
        String userAge = request.getParameter("userAge");
        String courseNo = request.getParameter("courseNo");
        String courseTitle = request.getParameter("courseTitle");
        if (userAge.isEmpty()) {
            userAge = "0";
        }
        String userGender = request.getParameter("userGender");
        String userEmail = request.getParameter("userEmail");
        String userAddress = request.getParameter("userAddress");

        // 检查userId是否已经存在
        TUser userEntity = registerService.getUserByUserId(userId);
        if (userEntity != null) {
            // 将异常信息存入请求域
            request.setAttribute("userIdErrMsg", SipmsCourtConst.USERID_EXIST_MESSAGE);
            inputErrFlag = true;
        }
        if (password == null || password.trim().isEmpty()) {
            request.setAttribute("passwordErrMsg", ("Password" + SipmsCourtConst.REQUIRED_MESSAGE));
            inputErrFlag = true;
        } else {
            String reg = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
            if (!password.matches(reg)) {
                request.setAttribute("passwordErrMsg", SipmsCourtConst.PW_NG_MESSAGE);
                inputErrFlag = true;
            }
        }
        if (!password.equals(passwordAgain)) {
            request.setAttribute("passwordAgainErrMsg", SipmsCourtConst.PW_AGAIN_MESSAGE);
            inputErrFlag = true;
        }
        if (userCategory == null || userCategory.trim().isEmpty()) {
            request.setAttribute("userCategoryErrMsg", ("Category" + SipmsCourtConst.REQUIRED_MESSAGE));
            inputErrFlag = true;
        } else {
            if (userCategory.equals("teacher")) {
                if (courseNo == null || courseNo.trim().isEmpty()) {
                    request.setAttribute("userCategoryErrMsg", ("Course No" + SipmsCourtConst.REQUIRED_MESSAGE));
                    inputErrFlag = true;
                } else if (courseTitle == null || courseTitle.trim().isEmpty()) {
                    request.setAttribute("userCategoryErrMsg", ("Course Title" + SipmsCourtConst.REQUIRED_MESSAGE));
                    inputErrFlag = true;
                } else if (courseService.getCourseByCourseNo(courseNo) != null) {
                    request.setAttribute("userCategoryErrMsg", (SipmsCourtConst.COURSE_EXIST_MESSAGE));
                    inputErrFlag = true;
                }
            }
        }
        if (userFirstName == null || userFirstName.trim().isEmpty()) {
            request.setAttribute("firstNameErrMsg", ("First Name" + SipmsCourtConst.REQUIRED_MESSAGE));
            inputErrFlag = true;
        }
        if (userLastName == null || userLastName.trim().isEmpty()) {
            request.setAttribute("lastNameErrMsg", ("Last Name" + SipmsCourtConst.REQUIRED_MESSAGE));
            inputErrFlag = true;
        }
        try {
            Integer userAgeNum = Integer.parseInt(userAge);
            if (userAgeNum < 0) {
                request.setAttribute("ageErrMsg", ("Age" + SipmsCourtConst.POSITIVE_INT_MESSAGE));
                inputErrFlag = true;
            }
        } catch (Exception e) {
            request.setAttribute("ageErrMsg", ("Age" + SipmsCourtConst.POSITIVE_INT_MESSAGE));
            inputErrFlag = true;
        }

        if (userEmail == null || userEmail.trim().isEmpty()) {
            request.setAttribute("emailErrMsg", ("Email" + SipmsCourtConst.REQUIRED_MESSAGE));
            inputErrFlag = true;
        } else {
            String emailReg = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
            if (!userEmail.matches(emailReg)) {
                request.setAttribute("emailErrMsg", (SipmsCourtConst.EMAIL_ERR_MESSAGE));
                inputErrFlag = true;
            }
        }

        if (inputErrFlag) {
            request.setAttribute("userId", userId);
            request.setAttribute("password", password);
            request.setAttribute("userCategory", userCategory);
            request.setAttribute("userFirstName", userFirstName);
            request.setAttribute("userLastName", userLastName);
            request.setAttribute("userAge", userAge);
            request.setAttribute("userGender", userGender);
            request.setAttribute("userEmail", userEmail);
            request.setAttribute("userAddress", userAddress);
            request.setAttribute("courseNo", courseNo);
            request.setAttribute("courseTitle", courseTitle);

        } else {
            TUser newUser = new TUser(userId, password, userCategory, userFirstName, userLastName,
                    Integer.parseInt(userAge), userGender, userEmail, userAddress);

            registerService.registerUser(newUser);

            if ("teacher".equals(userCategory)) {

                TCourse course = new TCourse();
                course.setCourseNo(courseNo);
                course.setCourseTitle(courseTitle);
                course.setTeacherUserId(userId);
                courseService.insertCourse(course);
            }

            request.setAttribute("registerOkMessage", SipmsCourtConst.REGISTER_OK_MESSAGE);
            clearUserInfo(request);
        }

        templateName = "register";
        processTemplate(templateName, request, response);

    }

    private void clearUserInfo(HttpServletRequest request) {
        request.setAttribute("userId", "");
        request.setAttribute("password", "");
        request.setAttribute("userCategory", "");
        request.setAttribute("userFirstName", "");
        request.setAttribute("userLastName", "");
        request.setAttribute("userAge", "");
        request.setAttribute("userGender", "");
        request.setAttribute("userEmail", "");
        request.setAttribute("userAddress", "");
        request.setAttribute("courseNo", "");
        request.setAttribute("courseTitle", "");
    }
}
