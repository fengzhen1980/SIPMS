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
        if (userAge.isEmpty()) {
            userAge = "0";
        }
        String userGender = request.getParameter("userGender");
        String userEmail = request.getParameter("userEmail");
        String userAddress = request.getParameter("userAddress");

        TUser newUser = new TUser(userId, password, userCategory, userFirstName, userLastName,
                Integer.parseInt(userAge), userGender, userEmail, userAddress);

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
        }
        if (!password.equals(passwordAgain)) {
            request.setAttribute("passwordAgainErrMsg", SipmsCourtConst.PW_AGAIN_MESSAGE);
            inputErrFlag = true;
        }
        if (userCategory == null || userCategory.trim().isEmpty()) {
            request.setAttribute("userCategoryErrMsg", ("Category" + SipmsCourtConst.REQUIRED_MESSAGE));
            inputErrFlag = true;
        }
        if (userFirstName == null || userFirstName.trim().isEmpty()) {
            request.setAttribute("firstNameErrMsg", ("First Name" + SipmsCourtConst.REQUIRED_MESSAGE));
            inputErrFlag = true;
        }
        if (userLastName == null || userLastName.trim().isEmpty()) {
            request.setAttribute("lastNameErrMsg", ("Last Name" + SipmsCourtConst.REQUIRED_MESSAGE));
            inputErrFlag = true;
        }
        if (userEmail == null || userEmail.trim().isEmpty()) {
            request.setAttribute("emailErrMsg", ("Email" + SipmsCourtConst.REQUIRED_MESSAGE));
            inputErrFlag = true;
        }

        if (inputErrFlag) {
            writeBack(newUser, request);
        } else {
            registerService.registerUser(newUser);

            if ("teacher".equals(userCategory)) {
                String courseNo = request.getParameter("courseNo");
                String courseTitle = request.getParameter("courseTitle");
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

    private void writeBack(TUser user, HttpServletRequest request) {
        request.setAttribute("userId", user.getUserId());
        request.setAttribute("password", user.getUserPassword());
        request.setAttribute("userCategory", user.getUserCategory());
        request.setAttribute("userFirstName", user.getUserFirstName());
        request.setAttribute("userLastName", user.getUserLastName());
        request.setAttribute("userAge", user.getUserAge());
        request.setAttribute("userGender", user.getUserGender());
        request.setAttribute("userEmail", user.getUserEmail());
        request.setAttribute("userAddress", user.getUserAddress());
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
    }
}
